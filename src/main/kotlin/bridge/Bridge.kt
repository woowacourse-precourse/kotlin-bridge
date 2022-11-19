package bridge

class Bridge(private val bridge: List<String>) {
    var upBridge = ""
    var downBridge = ""
    var currentLocation = 0
    private var hit = ""
    fun matches(upDown: String): Boolean {
        if (bridge[currentLocation] == upDown) {
            return true
        }
        return false
    }

    fun setHit(hit: String) {
        this.hit = hit
    }

    fun getHit() = hit
    fun clear() {
        currentLocation = 0
        upBridge = ""
        downBridge = ""
        hit = ""
    }

    fun finish(): Boolean {
        if (currentLocation == bridge.size) {
            if (getHit() == "O")
                return true
        }
        return false
    }

    fun moveCurrentLocation() {
        currentLocation++
    }
    fun getMap(): Pair<String, String> {
        return upBridge to downBridge
    }

}