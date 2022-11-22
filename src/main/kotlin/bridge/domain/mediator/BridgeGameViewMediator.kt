package bridge.domain.mediator

import bridge.common.INPUT_BRIDGE_SIZE_MESSAGE
import bridge.common.INPUT_GAME_COMMAND_MESSAGE
import bridge.common.INPUT_MOVING_MESSAGE
import bridge.domain.mediator.type.InputType
import bridge.domain.mediator.type.OutputType
import bridge.ui.view.InputView
import bridge.ui.view.OutputView

class BridgeGameViewMediator(
    private val inputView: InputView,
    private val outputView: OutputView,
) {
    // read
    fun readBridgeSize(): Int {
        outputView.printMessage(message = INPUT_BRIDGE_SIZE_MESSAGE)
        return inputView.readBridgeSize()
    }

    fun readMoving(): String {
        outputView.printMessage(message = INPUT_MOVING_MESSAGE)
        return inputView.readMoving()
    }

    fun readGameCommand(): String {
        outputView.printMessage(message = INPUT_GAME_COMMAND_MESSAGE)
        return inputView.readGameCommand()
    }

    // write
    fun printStartMessage() {
        outputView.printStartMessage()
    }

    fun printResult(mapInfo: List<String>, gameSuccessResult: String, numberOfTry: Int) {
        outputView.printResult(mapInfo, gameSuccessResult, numberOfTry)
    }

    fun printMap(gameMap: List<String>) {
        outputView.printMap(gameMap)
    }


    // TODO : read, write로만 호출하는 방법?
//    fun read(inputType: InputType): String {
//        return when (inputType) {
//            InputType.BRIDGE_SIZE ->  {
//                outputView.printMessage(message = INPUT_BRIDGE_SIZE_MESSAGE)
//                inputView.readBridgeSize()
//            }
//            InputType.MOVING -> {
//                outputView.printMessage(message = INPUT_MOVING_MESSAGE)
//                inputView.readMoving()
//            }
//            InputType.GAME_COMMAND -> {
//                outputView.printMessage(message = INPUT_GAME_COMMAND_MESSAGE)
//                inputView.readGameCommand()
//            }
//        }
//    }
//
//    fun write(outputType: OutputType) {
//        when (outputType) {
//            OutputType.MESSAGE -> outputView.printMessage()
//        }
//    }
}