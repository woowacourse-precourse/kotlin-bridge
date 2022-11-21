package bridge

fun main() {
    val bridgeGame = BridgeController()
    while(true) {
        bridgeGame.startBridgeGame()
        if(bridgeGame.isFinished()) {
            if(bridgeGame.isSuccess())
                break
            if(!bridgeGame.retryOrExit())
                break
        }
    }
}
