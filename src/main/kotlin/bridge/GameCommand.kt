package bridge

enum class GameCommand(private val command: String) {
    RESTART("R"),
    QUIT("Q");

    fun getGameCommand() = command
}