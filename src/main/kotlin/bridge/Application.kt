package bridge

import bridge.constant.*

private val inputView=InputView()
private val outputView=OutputView()
private val bridgeMaker=BridgeMaker(BridgeRandomNumberGenerator())
private val bridgeGame=BridgeGame()
private var _bridge:Bridge?=null
    set(value){
        if(field==null){
            field=value
        }
        else{
            throw RuntimeException("bridge is already set")
        }
    }
private val bridge
    get()= checkNotNull(_bridge)

fun makeBridge(){
    val bridgeSize=inputView.readBridgeSize()
    _bridge=Bridge(bridgeMaker.makeBridge(bridgeSize))

}
fun movePlayer():Int{
    val mv= inputView.readMoving()
    bridgeGame.move(mv, bridge)
    outputView.printMap(bridge)

    return bridge.checkGameEnd()
}
fun requestRetryOrQuit():Int{
    return 0
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
    while(playGame()== CORRECT){}

}
