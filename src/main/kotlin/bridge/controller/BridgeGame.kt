package bridge.controller

import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator
import bridge.domain.*
import bridge.presentation.InputView
import bridge.presentation.OutputView
import bridge.util.RETRIAL

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame : Game {
    private val inputView: InputView by lazy { InputView() }
    private val outputView: OutputView by lazy { OutputView() }

    private lateinit var bridge: Bridge
    private val bridgeMaker: BridgeMaker by lazy { BridgeMaker(BridgeRandomNumberGenerator()) }
    private val tryCounter: TryCounter by lazy { TryCounter() }
    private var path = Path()

    override fun start() {
        outputView.printGameStart()
        val bridgeSize = askBridgeSize()
        outputView.printNewLine()

        bridge = Bridge(bridgeMaker.makeBridge(bridgeSize))

        do {
            val (gameResult, finalBridgeRoute) = startGame()
            if (gameResult == Result.SUCCESS) { // 성공시 결과 출력
                val finalRoute = finalBridgeRoute.asList()
                result(gameResult, finalRoute)
                break
            } else { // 실패시
                val isContinueGame = retry() // 재시도를 물음
                if (isContinueGame) { // 재시도한다면 초기화하고 다시 시작
                    init()
                } else { // 재시도하지 않는다면 최종경로 출력
                    val finalRoute = finalBridgeRoute.asList()
                    result(gameResult, finalRoute)
                    break
                }
            }
        } while (true)
    }

    private fun startGame(): Pair<Result, Route> {
        val bridgeSize = bridge.size()
        val playerRoute = Route(bridge = bridge)

        tryCounter.plus()
        for (round in 0 until bridgeSize) {
            move()
            drawRoute(playerRoute.addPath(path))

            val isFail = path.checkDirection(bridge.directionOf(round), round).not()
            if (isFail) {
                return Pair(Result.FAIL, playerRoute)
            }
        }
        return Pair(Result.SUCCESS, playerRoute)
    }

    private fun askBridgeSize(): Int {
        outputView.printBridgeLengthQuestion()

        var bridgeSize = 0
        runCatching {
            bridgeSize = inputView.readBridgeSize()
        }.onFailure {
            outputView.printError(it)
            bridgeSize = askBridgeSize()
        }

        return bridgeSize
    }

    private fun drawRoute(route: Route) {
        outputView.printMap(route.asList())
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

    private fun init() {
        path = Path()
    }

    private fun result(gameResult: Result, map: List<List<Mark>>) {
        outputView.printResult(gameResult, tryCounter.count(), map)
    }

    private fun move() {
        outputView.printDirectionQuestion()
        runCatching {
            path = path.createNewPath(inputView.readDirection())
        }.onFailure {
            outputView.printError(it)
            move()
        }
    }
}