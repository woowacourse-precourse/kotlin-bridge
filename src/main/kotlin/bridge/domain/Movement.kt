package bridge.domain

import bridge.CommandException
import bridge.ERROR
import bridge.utils.ErrorType
import bridge.MOVEMENT

class Movement(private val direction: String) {
    init {
        CommandException(MOVEMENT, direction)
        require(isRightDirection()) { ERROR.format(MOVEMENT + ErrorType.DRIECTION.errorMessage) }
    }

    private fun isRightDirection(): Boolean =
        direction == UP || direction == DOWN

    companion object {
        const val UP = "U"
        const val DOWN = "D"
    }
}