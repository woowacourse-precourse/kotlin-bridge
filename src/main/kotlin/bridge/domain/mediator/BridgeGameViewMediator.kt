package bridge.domain.mediator

import bridge.common.INPUT_BRIDGE_SIZE_MESSAGE
import bridge.common.INPUT_GAME_COMMAND_MESSAGE
import bridge.common.INPUT_MOVING_MESSAGE
import bridge.domain.processor.BridgeCrossingProcessor
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

    fun  printMap(gameMap: List<String>) {
        outputView.printMap(gameMap)
    }


    // TODO: 게임에선 read, write만 호출하고 내부적으로 분기하는 방법 없나?
    fun read() {}
    fun write() {}
}