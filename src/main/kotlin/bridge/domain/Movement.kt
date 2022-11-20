package bridge.domain

import bridge.CommandException
import bridge.ERROR
import bridge.utils.ErrorType
import bridge.MOVEMENT
import bridge.utils.DOWN
import bridge.utils.UP

class Movement(private val direction: String) {
    init {
        CommandException(MOVEMENT, direction)
        require(isRightDirection()) { ERROR.format(MOVEMENT + ErrorType.DRIECTION.errorMessage) }
    }

    private fun isRightDirection(): Boolean =
        direction == UP || direction == DOWN
}