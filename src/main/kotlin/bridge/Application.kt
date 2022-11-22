package bridge

import bridge.constant.*

private val inputView=InputView()
private val outputView=OutputView()
private val bridgeMaker=BridgeMaker(BridgeRandomNumberGenerator())
private val bridgeGame=BridgeGame()
private var bridge_:Bridge?=null
private val bridge
    get()= checkNotNull(bridge_)

fun makeBridge(){
    val bridgeSize=inputView.readBridgeSize()
    bridge_=Bridge(bridgeMaker.makeBridge(bridgeSize))

}
fun movePlayer():Int{
    val mv= inputView.readMoving()
    bridgeGame.move(mv, bridge)
    outputView.printMap(bridge)

    return bridge.checkGameEnd()
}
fun requestRetryOrQuit():Int{
    val playerInput= inputView.readGameCommand()
    return if(playerInput=="R"){
        bridgeGame.retry(bridge)
        CORRECT
    }
    else{
        END
    }
}
fun playGame():Int{
    val mvResult= movePlayer()
    when(mvResult){
        WRONG->{
            return requestRetryOrQuit()
        }
        END->{
            return END
        }
    }
    return CORRECT
}
fun main() {
    println(GAME_START_MSG)
    makeBridge()
    while(playGame()== CORRECT);
    outputView.printResult(bridge, bridgeGame)
}
