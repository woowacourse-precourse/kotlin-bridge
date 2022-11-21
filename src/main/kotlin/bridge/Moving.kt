package bridge

enum class Moving(private val direction: String, private val num: Int) {
    UP("U",1),
    DOWN("D",0);

    fun getMovDirection() = direction
    fun getMovNumber() = num
}