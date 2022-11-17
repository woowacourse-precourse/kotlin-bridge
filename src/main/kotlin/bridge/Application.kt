package bridge

var order : Int = 0
var tryCount : Int = 1
var result = false
var endGame = false

fun main() {
    val bridge = initBridge()
    while(!endGame){
        BridgeGame().move(bridge)
    }
    OutputView().printResult(result)
}

fun initBridge(): List<String> {
    val size = InputView().readBridgeSize()
    return BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(size)
}