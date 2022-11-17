package bridge

class Bridge(private val size: Int) {

    private val upBridge = mutableListOf<String>()
    private val downBridge = mutableListOf<String>()
    private val idx : Int = 0

    fun movePossible(input : String, bridgeMap : List<String>) : Boolean {
        return input.equals(bridgeMap[idx])
    }
}