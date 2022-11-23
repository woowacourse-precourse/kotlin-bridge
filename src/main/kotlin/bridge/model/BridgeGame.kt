package bridge.model


class BridgeGame(private val goalBridge: List<String>, private val bridgeBoard: BridgeBoard) {
    var attempts = 1

    fun move(moving: String) {
        if(goalBridge[bridgeBoard.board[0].size] == moving){
            bridgeBoard.updateBoard(true, moving)
        }else
            bridgeBoard.updateBoard(false, moving)
    }

    fun retry(bridgeBoard: BridgeBoard){
        bridgeBoard.clearBoard()
        attempts++
    }

}
