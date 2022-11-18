package bridge

var order: Int = 0
var tryCount: Int = 1
var result = false
var endGame = false

fun main() {
    println("다리 건너기 게임을 시작합니다.")
    val bridge = initBridge()
    println("")
    while (!endGame) {
        BridgeGame().move(bridge)
    }
    OutputView().printResult(result)
}

fun initBridge(): List<String> {
    val size = InputView().readBridgeSize()
    return BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(size)
}