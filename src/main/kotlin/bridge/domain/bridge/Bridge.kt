package bridge.domain.bridge

class Bridge(private val bridge: List<String>) : List<String> by bridge {
    fun directionOf(index: Int) = bridge[index]
}