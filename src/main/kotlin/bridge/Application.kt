package bridge

import util.Game
import view.InputView

fun main() {
    var isDone = true
    var attempts = 1
    while(isDone){
        isDone = false
        val bridgeSize = InputView().readBridgeSize()
        val bridgeLetter = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSize)
        if(BridgeGame().startGame(bridgeSize, bridgeLetter)){
            attempts++
            isDone = true
        }
    }
    print("${Game.TOTAL_ATTEMPTS.message}$attempts")
}



