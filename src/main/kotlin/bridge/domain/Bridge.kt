package bridge.domain

class Bridge(private val blocks: List<String>) {
    fun crossable(index: Int, playerMove: String): Boolean {
        if (blocks[index] == playerMove)
            return true
        return false
    }

    fun getSize(): Int {
        return blocks.size
    }
}