package bridge.controller

import bridge.BridgeGame
import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator
import bridge.model.BridgeStatus
import bridge.view.InputView
import bridge.view.OutputView

class BridgeGameController(
    private val bridgeGame: BridgeGame,
    private val inputView: InputView,
    private val outputView: OutputView
) {

    init {
        inputView.gameStart()
        bridgeGame.initGame(
            size = inputView.readBridgeSize(),
            maker = BridgeMaker(BridgeRandomNumberGenerator())
        )
    }

    fun play() {
        with(bridgeGame) {
            do {
                val result = bridgeGame.move(inputView.readMoving())
                bridgeGame.updateMap(result)
                onFinish(result)
                onSuccess(result)
                onFail(result)
            } while (!isEnded())
        }
    }

    private fun onFail(result: BridgeStatus) {
        with(bridgeGame) {
            result.isFail {
                outputView.printMap(getBridgeMap())
                if (retry(inputView.readGameCommand())) return@isFail
                finish(result)
            }
        }
    }

    private fun onSuccess(result: BridgeStatus) {
        result.isSuccess {
            outputView.printMap(bridgeGame.getBridgeMap())
        }
    }

    private fun onFinish(result: BridgeStatus) {
        with(bridgeGame) {
            result.isFinish {
                outputView.printEndMessage()
                outputView.printMap(getBridgeMap())
                outputView.printResult(result, getTotalCount())
            }
        }
    }

}

