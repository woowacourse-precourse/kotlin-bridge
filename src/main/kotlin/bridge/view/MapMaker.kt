package bridge.view

import bridge.domain.Direction
import bridge.domain.PlayerBlock

object MapMaker {
    fun makeMap(blocks: List<PlayerBlock>): String {
        val up = StringBuilder("")
        val down = StringBuilder("")
        appendMark(up, down, MapMark.OPEN.mark())
        blocks.forEachIndexed { index, playerBlock ->
            appendBlock(playerBlock, up, down)
            appendMark(up, down, getBoundary(index, blocks.size))
        }
        appendMark(up, down, MapMark.CLOSE.mark())
        return up.append("\n").append(down).toString()
    }

    private fun appendBlock(
        playerBlock: PlayerBlock,
        up: StringBuilder,
        down: StringBuilder
    ) {
        when (playerBlock.getDirection()) {
            Direction.UP -> {
                up.append(" $playerBlock ")
                down.append("   ")
            }
            Direction.DOWN -> {
                up.append("   ")
                down.append(" $playerBlock ")
            }
        }
    }

    private fun appendMark(up: StringBuilder, down: StringBuilder, mark: String) {
        up.append(mark)
        down.append(mark)
    }

    private fun getBoundary(index: Int, blockSize: Int) =
        if (index < blockSize - 1) MapMark.BOUNDARY.mark() else ""

}