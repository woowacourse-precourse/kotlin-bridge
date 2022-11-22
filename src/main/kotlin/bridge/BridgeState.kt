package bridge

import view.InputView
import view.OutputView

class BridgeState {

    private val inputView = InputView()
    private val outputView = OutputView()

    private var _bridgeLength = 0
    val bridgeLength get() = _bridgeLength

    private var _inputCount = 0

    private val userState = mutableListOf<String>()

    fun inputBridgeLengthPart() {
        outputView.printStartGame()
        println()
        outputView.printInputBridgeLength()
        _bridgeLength = inputView.readBridgeSize()
        println()
    }

    fun bridgeMovePart(bridge: List<String>) {
        outputView.printMoveBridge()
        val command = inputView.readMoving()
        userState.add(command)
        _inputCount += 1
        outputView.printMap(bridge, userState)
    }

    fun isUserLive(bridge: List<String>): Boolean {
        return userState.filterIndexed { idx, it ->
            bridge[idx] != it
        }.isEmpty()
    }

    fun gameRetry(): Boolean {
        outputView.printRetryGame()
        val command = inputView.readGameCommand()
        if (command == RETRY_COMMAND) {
            userState.clear()
            return true
        }
        return false
    }

    fun gameFinish(bridge: List<String>, isSuccess: Boolean) {
        outputView.apply {
            printResult()
            printMap(bridge, userState)
            printGameSuccess(isSuccess)
            printTryCount(_inputCount)
        }
    }


    companion object {
        const val RETRY_COMMAND = "R"
    }
}
