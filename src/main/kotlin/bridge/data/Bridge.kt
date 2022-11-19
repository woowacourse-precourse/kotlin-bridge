package bridge.data

class Bridge(private val bridge: List<String>) {
    var currentLocation = 0
    fun matches(upDown: String): Boolean {
        if (bridge[currentLocation] == upDown) {
            return true
        }
        return false
    }


    fun clear() {
        currentLocation = 0
    }

    fun finish(hit: String): Boolean {
        if (currentLocation == bridge.size) {
            if (hit == "O")
                return true
        }
        return false
    }

    fun moveCurrentLocation() {
        currentLocation++
    }


}