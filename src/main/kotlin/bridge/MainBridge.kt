package bridge

import bridge.presentation.InputView
import bridge.presentation.OutputView

class MainBridge {
    private val input = InputView()
    private val output = OutputView()
    private val bridgeGame: BridgeGame

    init {
        bridgeGame = bridgeSetUp()
    }
    private fun bridgeSetUp(): BridgeGame {
        output.printStartGame()
        val bridgeSize = input.readBridgeSize()
        val bridge = BridgeMaker(BridgeRandomNumberGenerator())
            .makeBridge(bridgeSize)
        return BridgeGame(bridge)
    }
    private fun gameStatus(status: String): Int {
        if (status == "SUCCESS") return 1
        if (status == "FAIL") {
            output.printGameCommand()
            val restart = input.readGameCommand()
            if (restart == "R") bridgeGame.retry()
            else return 0
        }
        return -1
    }
    fun bridgeGameRepeat() {
        var status = -1
        while (status < 0) {
            output.printGetMoving()
            bridgeGame.move(input.readMoving())
            output.printMap(bridgeGame)
            status = gameStatus(bridgeGame.isGameContinue())
        }
        output.printResult(bridgeGame, if (status == 1) "성공" else "실패")
    }
}