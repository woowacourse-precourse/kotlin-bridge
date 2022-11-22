package bridge.domain

import bridge.sentence.ErrorSentence

enum class Direction(private val hotKey: String, private val number: Int) {
    UP("U", 1),
    DOWN("D", 0);

    fun isMatch(hotKey: String) = this.hotKey == hotKey

    fun isMatch(number: Int) = this.number == number

    fun hotKey() = hotKey

    fun number() = number

    companion object {
        fun getDirection(hotKey: String) =
            when {
                UP.isMatch(hotKey) -> UP
                DOWN.isMatch(hotKey) -> DOWN
                else -> throw IllegalArgumentException(ErrorSentence.MOVE.sentence())
            }

        fun getDirection(number: Int) =
            when {
                UP.isMatch(number) -> UP
                DOWN.isMatch(number) -> DOWN
                else -> throw IllegalArgumentException(ErrorSentence.MOVE_NUMBER.sentence())
            }
    }
}