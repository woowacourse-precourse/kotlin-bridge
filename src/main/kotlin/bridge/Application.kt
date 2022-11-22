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


fun makeBridge(){
    val bridgeSize=inputView.readBridgeSize()
    _bridge=Bridge(bridgeMaker.makeBridge(bridgeSize))

}

fun main() {
    println(GAME_START_MSG)
    makeBridge()
}
