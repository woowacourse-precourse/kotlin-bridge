package bridge

class Bridge(
    private val bridgeInfo: List<String>
) {

    fun isCrossable(position: Int, userMove: String): Boolean {
        if (bridgeInfo[position] == userMove) {
            return true
        }
        return false
    }

    fun getBridgeSize(): Int {
        return bridgeInfo.size
    }
}