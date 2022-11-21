package bridge

enum class Moving(private val direction: String) {
    UP("U"),
    DOWN("D");

    fun getMovDirection() = direction
}