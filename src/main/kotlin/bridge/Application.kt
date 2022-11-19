package bridge

var check = 0
var count = 1
fun playgame(){
    val bridge = buildBridge()
    BridgeGame().playgame(bridge)

}
fun buildBridge(): List<String> {
    val length = InputView().readBridgeSize()
    println(length)

    return BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(length)
}
fun main() {
    println("다리 건너기 게임을 시작합니다")
    playgame()
}
