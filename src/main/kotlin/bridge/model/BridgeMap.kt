package bridge.model

class BridgeMap {

    private val upperMap: MutableList<String> = mutableListOf()
    private val lowerMap: MutableList<String> = mutableListOf()

    fun clear() {
        upperMap.clear()
        lowerMap.clear()
    }

    override fun toString(): String {
        val result = StringBuilder()
        buildUpperMap(result)
        result.append("\n")
        buildLowerMap(result)
        return result.toString()
    }

    private fun buildLowerMap(result: StringBuilder) {
        result.append(BRIDGE_START)
        for (idx in 0 until lowerMap.size) {
            result.append(lowerMap[idx])
            if (idx == lowerMap.size - 1) continue
            result.append(BRIDGE_MIDDLE)
        }
        result.append(BRIDGE_END)
    }

    private fun buildUpperMap(result: StringBuilder) {
        result.append(BRIDGE_START)
        for (idx in 0 until upperMap.size) {
            result.append(upperMap[idx])
            if (idx == upperMap.size - 1) continue
            result.append(BRIDGE_MIDDLE)
        }
        result.append(BRIDGE_END)
    }

    fun update(result: BridgeStatus) {
        when (result) {
            is BridgeStatus.FINISH -> addSuccess(result.getDirection())
            is BridgeStatus.SUCCESS -> addSuccess(result.getDirection())
            is BridgeStatus.FAIL -> addFail(result.getDirection())
        }
    }

    private fun addFail(direction: String) {
        if (direction == "U") {
            upperMap.add("X")
            lowerMap.add(" ")
            return
        }
        upperMap.add(" ")
        lowerMap.add("X")
    }

    private fun addSuccess(direction: String) {
        if (direction == "U") {
            upperMap.add("O")
            lowerMap.add(" ")
            return
        }
        upperMap.add(" ")
        lowerMap.add("O")
    }

    companion object {
        private const val BRIDGE_START = "[ "
        private const val BRIDGE_MIDDLE = " | "
        private const val BRIDGE_END = " ]"
    }

}