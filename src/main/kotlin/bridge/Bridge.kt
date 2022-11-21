package bridge

class Bridge (size : Int = 0) {
    private val bridge : MutableList<String> = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(size).toMutableList()

    fun addUserBridge(movingKey : String) {
        bridge.add(movingKey)
    }

    fun bridgeComparison(targetBridge: Bridge) : Boolean{
        for(i in 0 until bridge.size){
            if(targetBridge.bridge[i] != bridge[i]){
                return false
            }
        }
        return true
    }
}