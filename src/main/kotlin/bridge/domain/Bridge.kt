package bridge.domain

class Bridge(private val bridge: List<String>) {
    fun getDirection(index: Int) = bridge[index]
}