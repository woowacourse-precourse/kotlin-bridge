package bridge.domain

import bridge.domain.resource.MoveType
import bridge.view.InputView
import bridge.view.OutputView

class BridgeGameManager(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    fun startGame() {
        outputView.printStart()
    }

    fun getBridgeSize(): Int {
        while (true) {
            try {
                return inputView.readBridgeSize()
            } catch (e: IllegalArgumentException) {
                println(e.message)
                continue
            }
        }
    }

    fun getMovement(): String {
        while (true) {
            try {
                return inputView.readMoving()
            } catch (e: IllegalArgumentException) {
                println(e.message)
                continue
            }
        }
    }

    fun printMap(path: List<String>, bridge: List<String>) {
        for (value in MoveType.values()) {
            outputView.printMap(MoveType.getMap(value, path, bridge))
        }
    }
}