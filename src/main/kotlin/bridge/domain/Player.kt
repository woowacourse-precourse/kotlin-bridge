package bridge.domain

class Player(
    private val blocks: MutableList<PlayerBlock> = mutableListOf(),
    private var tries: Int = 1
) {
    fun addPlayerBlock(playerBlock: PlayerBlock) = blocks.add(playerBlock)

    fun resetBlocks() {
        blocks.clear()
        tries++
    }

    fun nextIndex() = blocks.size

    fun getTries() = tries
    fun getPlayerBlocks(): List<PlayerBlock> = blocks
}