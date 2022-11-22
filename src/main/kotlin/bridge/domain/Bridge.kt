package bridge.domain

class Bridge(private val bridge: MutableList<String>) {

    fun get(index: Int): String = bridge[index]

}