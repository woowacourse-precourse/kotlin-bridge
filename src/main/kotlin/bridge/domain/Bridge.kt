package bridge.domain

import bridge.sentence.ErrorSentence

class Bridge(private val blocks: List<String>) {
    fun isMovable(index: Int, direction: Direction): Boolean {
        return index < blocks.size &&
                blocks[index] == direction.hotKey()
    }

    fun size() = blocks.size
}