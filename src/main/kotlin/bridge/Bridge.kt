package bridge

class Bridge (private val bridge:List<String>){
    var upBridge = ""
    var downBridge =""
    var currentLocation = 0
    private val hitBridge= MutableList(bridge.size + 1){""}
    fun checkCurrentLocation(upDown : String): Boolean {
        if(bridge[currentLocation] == upDown){
            return true
        }
        return false
    }

    fun move(hit: String) {
        currentLocation++
        hitBridge[currentLocation] = hit

    }
    fun getCurrentLocationHit() = hitBridge[currentLocation]

}