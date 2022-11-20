package bridge
import bridge.data.Games

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
            Games.UP.game -> jump = if(alive) UP_RIGHT else UP_WRONG
            Games.DOWN.game -> jump = if(alive) DOWN_RIGHT else DOWN_WRONG
        }
        playerMoves.add(jump)
        return playerMoves
    }

    fun retry(command:String):Boolean {
        if (command == Games.RETRY.game) return true
        return false
    }
}
