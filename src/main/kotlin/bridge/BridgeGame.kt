package bridge

import bridge.constants.Constants.RETRY_COMMAND


class BridgeGame {
    val movings: MutableList<String> = mutableListOf()

    fun move(moving : String, position : Int, bridge: List<String>) : Boolean {
        movings.add(moving)
        if (bridge[position] == movings[position]) {
            return true
        }
        return false
    }

    fun retry(gameCommand: String): Boolean {
        if (gameCommand == RETRY_COMMAND) return true
        return false
    }

    fun clearMovings() {
        movings.clear()
    }
}
