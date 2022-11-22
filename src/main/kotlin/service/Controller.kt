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
            bridgeGame.move(inputView.readMoving())                         // U/D 를 입력받아 moves에 저장
            outputView.printMap(bridgeGame.getState())                // 결과 출력
            if (bridgeGame.isFail()) {                                // 건널 수 없는 경우
                isPlaying = bridgeGame.retry(inputView.readGameCommand())   // 재시작 여부 확인
            }
            if (bridgeGame.isSuccess()) break                          // 정상 종료
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