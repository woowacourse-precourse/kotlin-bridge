package bridge.domain

import bridge.sentence.ErrorSentence

enum class GameCommand(private val hotKey: String) {
    RESTART("R"),
    QUIT("Q");

    fun isMatch(hotKey: String) = this.hotKey == hotKey

    companion object {
        fun getGameCommand(hotKey: String): GameCommand {
            return when {
                RESTART.isMatch(hotKey) -> RESTART
                QUIT.isMatch(hotKey) -> QUIT
                else -> throw IllegalArgumentException(ErrorSentence.RESTART.sentence())
            }
        }
    }
}