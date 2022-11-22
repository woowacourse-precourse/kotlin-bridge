package bridge

class Bridge(private val bridge: List<String>) {

    fun checkNextMove(playerInput: String,playerLocation:Int) :Boolean{
        return bridge[playerLocation + 1] == playerInput
    }

    fun checkGameEnd(playerLocation:Int): Boolean {
        return playerLocation == (bridge.size - 1)
    }


}