package bridge

class Bridge (private val bridge:List<String>){
    var upBridge = ""
    var downBridge =""
    var currentLocation = 0
    private val hitBridge= mutableListOf<String>("")
    fun checkCurrentLocation(upDown : String): Boolean {
        if(bridge[currentLocation] == upDown){
            return true
        }
        return false
    }

    fun move(hit: String) {
        currentLocation++
        hitBridge.add(hit)

    }
    fun getCurrentLocationHit() = hitBridge[currentLocation]
    fun retry() {
        currentLocation = 0
        upBridge = ""
        downBridge = ""
        hitBridge.clear()
        hitBridge.add("")

    }

}