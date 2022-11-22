package bridge.enums

enum class GameCommand(private val command: String) {
    RESTART("R"),
    QUIT("Q");

    fun getGameCommand() = command
}