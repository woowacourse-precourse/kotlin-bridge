package bridge.model

enum class Move(private val mark : String) {
    POSSIBLE("O") , IMPOSSIBLE("X");

    fun getMark() : String = mark

    fun isPossible() : Boolean = POSSIBLE == this

}