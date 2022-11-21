package bridge.domain

import bridge.view.InputView
import bridge.view.OutputView


class BridgeGameController {

    private val inputView = InputView()
    private val outputView = OutputView()
    private fun readMoving(): String {
        outputView.printReadMovingMent()
        return repeatInputProcess { inputView.readMoving() } as String
    }

    private fun repeatInputProcess(inputOperation: () -> Any): Any {
        do {
            try {
                return inputOperation()
            } catch (e: IllegalArgumentException) {
                outputView.printErrorMessage(e.message.toString())
            }
        } while (true)
    }

}
