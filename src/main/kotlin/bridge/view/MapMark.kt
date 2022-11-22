package bridge.view

enum class MapMark(private val mark: String) {
    OPEN("["),
    CLOSE("]"),
    BOUNDARY("|");

    fun mark() = mark
}