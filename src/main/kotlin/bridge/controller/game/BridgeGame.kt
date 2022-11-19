package bridge.controller.game

import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator
import bridge.domain.bridge.Bridge
import bridge.domain.counter.TryCounter
import bridge.domain.map.RouteMap
import bridge.domain.path.Path
import bridge.presentation.InputView
import bridge.presentation.OutputView
import bridge.util.constant.RETRIAL

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame : Game {
    private val inputView: InputView by lazy { InputView() }
    private val outputView: OutputView by lazy { OutputView() }

    private lateinit var bridge: Bridge
    private val bridgeMaker: BridgeMaker by lazy { BridgeMaker(BridgeRandomNumberGenerator()) }
    private val tryCounter: TryCounter by lazy { TryCounter() }
    private var playerPath = Path()


    override fun start() {
        outputView.printStartMessage()
        bridge = Bridge(bridgeMaker.makeBridge(bridgeSize()))

        do {
            val (gameResult, finalBridgeRoute) = startBridgeGame()
            val isRetry = result(gameResult, finalBridgeRoute)
        } while (isRetry)
    }


    /**
     * 게임 시작 비즈니스 로직 그룹
     * */

    private fun startBridgeGame(): Pair<Result, RouteMap> {
        val bridgeSize = bridge.size
        val playerRoute = RouteMap()
        increaseTryCount()

        for (round in 0 until bridgeSize) {
            val isLose = startRound(playerRoute, round).not()
            if (isLose) return Pair(Result.FAIL, playerRoute)
        }
        return Pair(Result.SUCCESS, playerRoute)
    }

    private fun startRound(playerRoute: RouteMap, round: Int): Boolean {
        move()
        drawRoute(playerRoute.addPath(playerPath, bridge))

        val realDirection = bridge.directionOf(round)
        val isRightPath = playerPath.checkDirection(realDirection, round)

        if (isRightPath) {
            return true
        }
        return false
    }

    private fun increaseTryCount() {
        tryCounter.plus()
    }


    /**
     * 게임 결과 관련 기능 그룹
     * */

    private fun result(gameResult: Result, playerRoute: RouteMap): Boolean = when (gameResult) {
        Result.SUCCESS -> successResult(gameResult, playerRoute)
        Result.FAIL -> failResult(gameResult, playerRoute)
    }

    private fun successResult(gameResult: Result, playerRoute: RouteMap): Boolean {
        printResult(gameResult, playerRoute)
        return false
    }

    private fun failResult(gameResult: Result, playerRoute: RouteMap): Boolean {
        if (retry()) {
            init()
            return true
        }
        printResult(gameResult, playerRoute)
        return false
    }

    private fun init() {
        playerPath = playerPath.init()
    }


    /**
     * 게임 진행 상황 출력 기능 그룹
     * */

    private fun drawRoute(route: RouteMap) {
        outputView.printMap(route)
    }

    private fun printResult(gameResult: Result, playerRoute: RouteMap) {
        outputView.printResult(gameResult, tryCounter.count(), playerRoute)
    }


    /**
     * 사용자 입력 기능 그룹
     * */

    private fun bridgeSize(): Int {
        outputView.printBridgeLengthQuestion()
        var bridgeSize = 0

        runCatching {
            bridgeSize = inputView.readBridgeSize()
        }.onFailure {
            outputView.printError(it)
            bridgeSize = bridgeSize()
        }
        return bridgeSize
    }

    private fun move() {
        outputView.printDirectionQuestion()

        runCatching {
            val direction = inputView.readDirection()
            playerPath = playerPath.add(direction)
        }.onFailure {
            outputView.printError(it)
            move()
        }
    }

    private fun retry(): Boolean {
        outputView.printRetryQuestion()
        var isRetry = false

        runCatching {
            isRetry = inputView.readGameCommand() == RETRIAL
        }.onFailure {
            outputView.printError(it)
            isRetry = retry()
        }
        return isRetry
    }
}