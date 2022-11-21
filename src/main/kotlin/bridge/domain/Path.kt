package bridge.domain

import bridge.util.ErrorMessage.ERROR_NOT_VALID_COMMAND
import java.lang.IllegalArgumentException

enum class Path(private val pathNumber: Int, private val path: String) {
    UP(1, "U"),
    DOWN(0, "D");

    fun getPath(): String {
        return path
    }
    companion object {
        fun valueOf(moveNumber: Int): String {
            return when (moveNumber) {
                UP.pathNumber -> UP.path
                DOWN.pathNumber -> DOWN.path
                else -> throw IllegalArgumentException(ERROR_NOT_VALID_COMMAND)
            }
        }
    }
}
