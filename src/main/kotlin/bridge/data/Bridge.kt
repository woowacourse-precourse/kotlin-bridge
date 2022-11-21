package bridge.data

class Bridge(private val bridge: List<String>) {
    var location = 0
    fun matches(upDown: String): Boolean {
        if (bridge[location] == upDown) {
            return true
        }
        return false
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


}