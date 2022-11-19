package bridge

class Bridge(
    val bridgeInfo: List<String>
) {

    fun isCrossable(position: Int, userMove: String): Boolean {
        if (bridgeInfo[position] == userMove) {
            return true
        }
        return false
    }
}