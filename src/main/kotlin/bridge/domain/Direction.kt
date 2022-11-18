package bridge.domain

enum class Direction(private val hotKey: String, private val number: Int) {
    UP("U", 1),
    DOWN("D", 0);

    fun isMatch(hotKey: String) = this.hotKey == hotKey
    fun isMatch(number: Int) = this.number == number
}