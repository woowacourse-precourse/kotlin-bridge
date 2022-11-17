package bridge

var order : Int = 0
var count : Int = 0

fun main() {
    val bridge = initBridge()
    BridgeGame().move(bridge)
}

fun initBridge(): List<String> {
    val size = InputView().readBridgeSize()
    return BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(size)
}