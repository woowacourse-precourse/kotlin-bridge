package bridge.controller

import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator
import bridge.domain.*
import bridge.presentation.InputView
import bridge.presentation.OutputView

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame : Game {
    private val inputView: InputView by lazy { InputView() }
    private val outputView: OutputView by lazy { OutputView() }

    private val bridgeMaker: BridgeMaker by lazy { BridgeMaker(BridgeRandomNumberGenerator()) }
    private lateinit var bridge: Bridge
    private val counter: Counter by lazy { Counter() }
    private var path = Path()

    override fun start() {
        outputView.printGameStart()
        val bridgeSize = askBridgeSize()
        bridge = Bridge(bridgeMaker.makeBridge(bridgeSize))

        do {
            val (gameResult, finalBridgeRoute) = startGame()
            if (gameResult == Result.SUCCESS) { // 성공시 결과 출력
                val finalRoute = finalBridgeRoute.route()
                result(gameResult, finalRoute)
                break
            } else { // 실패시

            }
        } while (true)
    }

    private fun startGame(): Pair<Result, BridgeRoute> {
        val bridgeSize = bridge.size()
        val bridgeRoute = BridgeRoute()

        counter.plus()
        for (round in 0 until bridgeSize) {
            move()

            val route = bridgeRoute.makeRoute(path, bridge)
            drawRoute(route)

            val isFail = path.checkDirection(bridge.getDirection(round), round).not()
            if (isFail) {
                return Pair(Result.FAIL, bridgeRoute)
            }
        }
        return Pair(Result.SUCCESS, bridgeRoute)
    }

    private fun askBridgeSize(): Int {
        outputView.printBridgeLengthQuestion()
        val bridgeSize = inputView.readBridgeSize()
        outputView.printNewLine()

        return bridgeSize
    }

    private fun drawRoute(route: List<List<Mark>>) {
        outputView.printMap(route)
    }

    private fun result(gameResult: Result, map: List<List<Mark>>) {
        outputView.printResult(gameResult, counter.count(), map)
    }

    private fun move() {
        outputView.printDirectionQuestion()
        path = path.createNewPath(inputView.readDirection())
    }
}