package bridge.domain.mediator

import bridge.common.INPUT_BRIDGE_SIZE_MESSAGE
import bridge.common.INPUT_GAME_COMMAND_MESSAGE
import bridge.common.INPUT_MOVING_MESSAGE
import bridge.domain.mediator.type.InputType
import bridge.ui.view.InputView
import bridge.ui.view.OutputView

class BridgeGameViewMediator(
    private val inputView: InputView,
    private val outputView: OutputView,
) {
    fun read(inputType: InputType): String {
        return when (inputType) {
            InputType.SIZE -> {
                outputView.printMessage(message = INPUT_BRIDGE_SIZE_MESSAGE)
                inputView.readBridgeSize()
            }
            InputType.MOVING -> {
                outputView.printMessage(message = INPUT_MOVING_MESSAGE)
                inputView.readMoving()
            }
            InputType.COMMAND -> {
                outputView.printMessage(message = INPUT_GAME_COMMAND_MESSAGE)
                inputView.readGameCommand()
            }
        }
    }

    fun write(message: String) {
        outputView.printMessage(message = message)
    }

    fun write(mapInfo: List<String>) {
        outputView.printMap(mapInfo = mapInfo)
    }

    fun write(mapInfo: List<String>, gameSuccessResult: String, numberOfTry: Int) {
        outputView.printResult(mapInfo = mapInfo, gameSuccessResult = gameSuccessResult, numberOfTry = numberOfTry)
    }
}