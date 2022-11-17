package bridge

var order : Int = 0
var tryCount : Int = 1

fun main() {
    val bridge = initBridge()
    while(order <= bridge.size){
        BridgeGame().move(bridge)
    }
}

fun initBridge(): List<String> {
    val size = InputView().readBridgeSize()
    return BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(size)
}