package bridge.domain

class Bridge(private val bridge: MutableList<String>) {

    fun get(index: Int): String = bridge[index]

    fun getWrongAnswerBridge(position: Int, value: String): Bridge {
        val tempBridge = mutableListOf<String>()
        tempBridge.addAll(bridge)
        tempBridge[position] = value
        return Bridge(tempBridge).getNowBridge(position)
    }

    fun getNowBridge(lastIndex: Int): Bridge = Bridge(bridge.subList(BRIDGE_START_INDEX, lastIndex + 1))

    override fun toString(): String = this.bridge.joinToString(SEPARATOR, PREFIX, POSTFIX)

    companion object {
        private const val BRIDGE_START_INDEX = 0
        private const val PREFIX = "[ "
        private const val POSTFIX = " ]"
        private const val SEPARATOR = " | "
    }
}