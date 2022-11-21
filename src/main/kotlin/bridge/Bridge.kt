package bridge

import bridge.util.BridgeMoving

data class Bridge(val steps: List<String>) {

    init {
        require(steps.size in 3..20) { BRIDGE_SIZE_ERROR_MESSAGE }
        require(steps.all { it == BridgeMoving.UP.character || it == BridgeMoving.DOWN.character }) { BRIDGE_LOCATION_ERROR_MESSAGE }
    }

    fun isMatchMoving(userMoving: String, userPosition: Int): Boolean {
        if (steps[userPosition] == userMoving) return true
        return false
    }

    fun length() = steps.size

    companion object {
        const val BRIDGE_SIZE_ERROR_MESSAGE = "[ERROR] 다리의 길이는 3 이상 20 이하여야 합니다."
        const val BRIDGE_LOCATION_ERROR_MESSAGE = "[ERROR] 다리의 위치는 위 또는 아래여야 합니다."
    }
}