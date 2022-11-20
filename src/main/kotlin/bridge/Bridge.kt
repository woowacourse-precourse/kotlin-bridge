package bridge

class Bridge(private val bridge : List<String>) {

    init {
        require(bridge.size in 3..20)
    }

    override fun toString(): String {
        return this.bridge.joinToString(prefix = "[ ", postfix = " ]", separator = " | ")
    }

}