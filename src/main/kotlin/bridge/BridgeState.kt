package bridge

import test.AAA
import view.InputView
import view.OutputView

class BridgeState {

    private val inputView = InputView()
    private val outputView = OutputView()

    private var _bridgeLength = 0

    private var _inputCount = 0

    private val userState = mutableListOf<String>()

    fun inputBridgeLengthPart() {
        outputView.printStartGame()
        println()
        outputView.printInputBridgeLength()
        _bridgeLength = inputView.readBridgeSize()
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


    companion object {
        const val RETRY_COMMAND = "R"
    }
}
