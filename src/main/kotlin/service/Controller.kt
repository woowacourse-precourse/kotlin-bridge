package service

import bridge.BridgeGame
import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator
import java.lang.IllegalArgumentException

class Controller {
    private var isPlaying = Message.ControllerEnum.RUNNING.state
    private lateinit var inputView: InputView
    private lateinit var outputView: OutputView
    private lateinit var bridgeGame: BridgeGame
    private lateinit var bridge: List<String>

    fun play() {
        setUpGame()
        runGame()
        endGame()
    }

    private fun setUpGame() {
        inputView = InputView()
        outputView = OutputView()
        inputView.startGame()
        val bridgeSize = inputView.readBridgeSize()
        bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSize)
        bridgeGame = BridgeGame(bridge)
    }

    private fun endGame() {
        outputView.printResult(bridgeGame.getResult())
        outputView.printResult(bridgeGame.getAnalysis(isPlaying))
    }

    private fun mainLogic() {
        do {
            bridgeGame.move(inputView.readMoving())
            outputView.printMap(bridgeGame.getState())
            if (bridgeGame.isFail()) {
                isPlaying = bridgeGame.retry(inputView.readGameCommand())
            }
            if (bridgeGame.isSuccess()) break
        } while (isPlaying)
    }

    private fun runGame() {
        try {
            mainLogic()
        } catch (e: IllegalArgumentException) {
            println(e)
        } catch (e: IllegalStateException) {
            println(e)
        }
    }
}