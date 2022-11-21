package bridge.controller

import bridge.BridgeGame
import bridge.model.BridgeResult
import bridge.view.InputView
import bridge.view.OutputView

class BridgeGameController(
    private val bridgeGame: BridgeGame,
    private val inputView: InputView,
    private val outputView: OutputView
) {

    init {
        inputView.gameStart()
        bridgeGame.initGame(inputView.readBridgeSize())
    }

    fun play() {
        with(bridgeGame) {
            do {
                val userInput = inputView.readMoving()
                move(userInput)
                updateMap(userInput)
                outputView.printMap(getBridgeMap())
                if (result() != BridgeResult.SUCCESS) handleResult(result(), getTotalCount())
            } while (result() != BridgeResult.FINISH)
        }
    }

    /**
     * 게임이 실패하거나 끝났을 때 결과출력 및 재시도 여부를 체크한다.
     * @param bridgeResult 다리를 건넜을 때 결과 enum class
     * @param totalCount 총 시도 횟수
     */
    private fun handleResult(result: BridgeResult, totalCount: Int) {
        outputView.printResult(result, totalCount)
        if (result == BridgeResult.FAIL) {
            if (bridgeGame.retry(inputView.readGameCommand())) {
                return
            }
            bridgeGame.finish()
        }
    }
}

