package bridge

import bridge.constants.Constants.RETRY_COMMAND


class BridgeGame {
    val movings: MutableList<String> = mutableListOf()

    fun move(moving: String, position: Int, bridge: List<String>): Boolean {
        movings.add(moving)
        return bridge[position] == movings[position]
    }

    fun retry(gameCommand: String): Boolean = gameCommand == RETRY_COMMAND

    fun clearMovings() {
        movings.clear()
    }
}
