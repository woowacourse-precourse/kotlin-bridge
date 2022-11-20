package bridge

class BridgeState {
    private val bridgeGame = BridgeGame()
    private val inputView = InputView()
    private val outputView = OutputView()
    private val player = Player()

    fun compare(bridge:List<String>):Boolean{
        var playerMoves = mutableListOf<List<String>>()
        for(index in bridge.indices){
            val upOrDown = inputView.readMoving()
            val alive = player.isAlive(bridge[index],upOrDown)
            insertMove(playerMoves,upOrDown,alive)
            if(!alive) return false
        }
        outputView.printResult(playerMoves)
        return true
    }
}