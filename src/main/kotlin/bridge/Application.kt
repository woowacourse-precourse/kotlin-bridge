package bridge

var order: Int = 0
var tryCount: Int = 1
var result = false
var endGame = false

fun main() {
    println("다리 건너기 게임을 시작합니다.")
    initBridge()
    println("")
    while (!endGame) {
        moveBridge()
    }
    OutputView().printResult(result)
}

fun initBridge(): List<String> {
    val size = InputView().readBridgeSize()
    return BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(size)
}

fun moveBridge(){
    val move = InputView().readMoving()
    val result =BridgeGame().move(move)
    OutputView().printMap()
    when(result){
        true -> BridgeGame().discriminateEnd(BridgeMaker.bridge)
        false -> BridgeGame().retry(InputView().readGameCommand())
    }
}