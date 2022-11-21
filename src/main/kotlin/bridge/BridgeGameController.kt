package bridge

import ui.InputView
import ui.OutputView
import values.Request

/**
 * 다리 건너기 게임의 진행을 관리하는 클래스
 */
class BridgeGameController {
    private val inputView: InputView = InputView()
    private val outputView: OutputView = OutputView()
    private val bridgeGame: BridgeGame = BridgeGame()

    fun runGame() {
        setGameInfoInit()

        while (bridgeGame.getMoveCount() < bridgeGame.getBridgeSize()) {
            println(Request.MOVING.message)
            bridgeGame.move(inputView.readMoving())
            outputView.printMap(bridgeGame.getGameProgress())

            if(!bridgeGame.isSuccess()) {
                println(Request.COMMAND.message)
                if(inputView.readGameCommand() == "R") bridgeGame.retry()
                else break
            }
        }

        outputView.printResult(bridgeGame)
    }

    private fun setGameInfoInit() {
        println("다리 건너기 게임을 시작합니다.")
        println()
        println(Request.BRIDGE_SIZE.message)
        bridgeGame.setBridgeSize(inputView.readBridgeSize())
        println()

        val bridgeRandomGenerator = BridgeRandomNumberGenerator()
        bridgeGame.setBridge(BridgeMaker(bridgeRandomGenerator).makeBridge(bridgeGame.getBridgeSize()))
    }

}