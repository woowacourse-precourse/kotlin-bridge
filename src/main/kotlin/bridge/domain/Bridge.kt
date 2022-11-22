package bridge.domain

class Bridge(private val bridge: MutableList<String>) {

    fun get(index: Int): String = bridge[index]

    fun setWrongAnswer(position: Int, value: String): Bridge {
        val tempBridge = mutableListOf<String>()
        tempBridge.addAll(bridge)
        tempBridge[position] = value
        return Bridge(tempBridge).subBridge(position)
    }

    fun subBridge(lastIndex: Int): Bridge = Bridge(bridge.subList(0, lastIndex + 1))

    override fun toString(): String = this.bridge.joinToString(prefix = "[ ", postfix = " ]", separator = " | ")
}