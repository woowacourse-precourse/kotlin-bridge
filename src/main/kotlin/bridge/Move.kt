package bridge

enum class Move(private val mark : String) {
    POSSIBLE("O") , IMPOSSIBLE("X");

    fun getMark() : String = mark

}