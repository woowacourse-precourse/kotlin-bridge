package bridge.domain

import bridge.util.ErrorMessage.ERROR_NOT_VALID_COMMAND
import java.lang.IllegalArgumentException

enum class Command(private val command: String) {
    UP("U"),
    DOWN("D"),
    QUIT("Q"),
    RETRY("R");

    fun value(): String {
        return command
    }

    companion object {
        fun valueOf(moveNumber: Int): String {
            return when (moveNumber) {
                1 -> UP.command
                0 -> DOWN.command
                else -> throw IllegalArgumentException(ERROR_NOT_VALID_COMMAND)
            }
        }
    }
}
