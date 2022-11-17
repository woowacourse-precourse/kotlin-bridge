package bridge.enum

enum class Direction(private val hotKey: Char, private val number: Int) {
    UP('U', 1),
    DOWN('D', 0);

    fun isMatch(hotKey: Char) = this.hotKey == hotKey
    fun isMatch(number: Int) = this.number == number
}