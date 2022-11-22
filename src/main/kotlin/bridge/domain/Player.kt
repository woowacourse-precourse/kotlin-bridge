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

    fun canContinue() = blocks.last().getIsMovable()

    fun isCompleted(bridgeSize: Int) = blocks.size == bridgeSize && canContinue()

    fun getTries() = tries

    fun getPlayerBlocks(): List<PlayerBlock> = blocks
}