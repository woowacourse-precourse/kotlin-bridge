package bridge

enum class GameCommand(
    private val gameCommand: String
) {
    UP("U"),
    DOWN("D"),
    RETRY("R"),
    QUIT("Q");

    fun getCommand(): String {
        return gameCommand;
    }
}