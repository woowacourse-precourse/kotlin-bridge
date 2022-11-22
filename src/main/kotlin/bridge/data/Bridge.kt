package bridge.data

import bridge.consol.Message.RIGHT
import bridge.consol.Message.WRONG

class Bridge(private val bridge: List<String>) {
    var location = 0
    fun match(upDown: String): String {
        if (bridge[location] == upDown) {
            return RIGHT
        }
        return WRONG
    }


    fun clear() {
        location = 0
    }

    fun finish(hit: String): Boolean {
        if (location == bridge.size) {
            if (hit == "O")
                return true
        }
        return false
    }

    fun moveCurrentLocation() {
        location++
    }

    fun isFirst(): Boolean {
        return location == 0
    }
}