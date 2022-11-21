package bridge

class Bridge(
    private val bridgeInfo: List<String>
) {

    init {
        assert(bridgeInfo.size in MIN_BRIDGE_LENGTH..MAX_BRIDGE_LENGTH)
    }

    fun isCrossable(position: Int, userMove: String): Boolean {
        if (bridgeInfo[position] == userMove) {
            return true
        }
        return false
    }

    fun getBridgeSize(): Int {
        return bridgeInfo.size
    }

    companion object {
        const val MIN_BRIDGE_LENGTH = 3
        const val MAX_BRIDGE_LENGTH = 20
    }
}