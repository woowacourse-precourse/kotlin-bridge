package bridge
import bridge.data.Games
import bridge.data.Moves

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {
    companion object{
        val UP_RIGHT = listOf("O"," ")
        val UP_WRONG = listOf("X"," ")
        val DOWN_RIGHT = listOf(" ","O")
        val DOWN_WRONG = listOf(" ","X")
    }
    fun move(playerMoves:MutableList<List<String>>,upOrDown:String,alive:Boolean):MutableList<List<String>>{
        var jump = listOf("")
        when (upOrDown) {
            Games.UP.game -> if(alive) jump = UP_RIGHT else UP_WRONG
            Games.DOWN.game -> if(alive) jump = DOWN_RIGHT else DOWN_WRONG
        }
        playerMoves.add(jump)
        return playerMoves
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {}
}
