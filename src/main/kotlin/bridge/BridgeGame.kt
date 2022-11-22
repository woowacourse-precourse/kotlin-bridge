package bridge

import bridge.constants.Constants.RETRY_COMMAND


class BridgeGame {
    val moves: MutableList<String> = mutableListOf()

    fun move(moving: String, position: Int, bridge: List<String>): Boolean {
        moves.add(moving)
        return bridge[position] == moves[position]
    }

    fun retry(gameCommand: String): Boolean = gameCommand == RETRY_COMMAND

    fun clearMovings() {
        moves.clear()
    }
}
