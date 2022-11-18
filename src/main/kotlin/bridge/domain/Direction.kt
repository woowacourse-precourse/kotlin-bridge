package bridge.domain

import bridge.sentence.ErrorSentence

enum class Direction(private val hotKey: String, private val number: Int) {
    UP("U", 1),
    DOWN("D", 0);

    fun isMatch(hotKey: String) = this.hotKey == hotKey
    fun isMatch(number: Int) = this.number == number

    companion object{
        fun getDirection(hotKey: String): Direction {
            return when{
                UP.isMatch(hotKey) -> UP
                DOWN.isMatch(hotKey) -> DOWN
                else -> throw IllegalArgumentException(ErrorSentence.MOVE.sentence())
            }
        }
    }
}