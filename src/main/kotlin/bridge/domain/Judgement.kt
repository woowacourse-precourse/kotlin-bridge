package bridge.domain

import bridge.utils.MOVING_FAILURE
import bridge.utils.MOVING_SUCCESS

class Judgement {
    fun compareDirection(playerDirection: String, computerDirection: String): String {
        if (playerDirection == computerDirection) {
            return MOVING_SUCCESS
        }
        return MOVING_FAILURE
    }
}