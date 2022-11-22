package bridge.model

import bridge.model.Bridge.Companion.BRIDGE_UPPER_SYMBOL

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
        if (direction == BRIDGE_UPPER_SYMBOL) {
            upperMap.add(BRIDGE_FAIL)
            lowerMap.add(BRIDGE_BLANK)
            return
        }
        upperMap.add(BRIDGE_BLANK)
        lowerMap.add(BRIDGE_FAIL)
    }

    private fun addSuccess(direction: String) {
        if (direction == BRIDGE_UPPER_SYMBOL) {
            upperMap.add(BRIDGE_CORRECT)
            lowerMap.add(BRIDGE_BLANK)
            return
        }
        upperMap.add(BRIDGE_BLANK)
        lowerMap.add(BRIDGE_CORRECT)
    }

    companion object {
        private const val BRIDGE_START = "[ "
        private const val BRIDGE_MIDDLE = " | "
        private const val BRIDGE_END = " ]"
        private const val BRIDGE_CORRECT = "O"
        private const val BRIDGE_FAIL = "X"
        private const val BRIDGE_BLANK = " "
    }

}