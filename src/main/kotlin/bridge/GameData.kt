package bridge

enum class GameStatus(val gameMsg:String) {
    CONTINUING(""), SUCCEEDED("성공"), FAILED("실패")
}

data class PlayerStatus(
    val playerDirection: Int,
    val isPlayerAlive: Boolean
)

enum class Direction(val direction: String, val directionNumber:Int){
     UP("U", 0),
}