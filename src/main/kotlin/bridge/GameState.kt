package bridge

import bridge.constants.BridgePhrases.INCORRECT_GAME_STATE_STRING_CODE

enum class GameState(val stringCode: String) {
    RESTART("R"),
    QUIT("Q");

    companion object {
        fun convertStringCodeToValue(stringCode: String): GameState =
            GameState.values().find { it.stringCode == stringCode } ?: throw IllegalStateException(
                INCORRECT_GAME_STATE_STRING_CODE
            )
    }
}
