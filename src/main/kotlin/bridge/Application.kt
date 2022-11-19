package bridge

fun playgame(){
    val bridge = buildBridge()
    BridgeGame().playgame(bridge)

}
fun buildBridge(): List<String>{
    val length = InputView().readBridgeSize()
    val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
    val bridge: List<String> = bridgeMaker.makeBridge(length)

    return bridge
}
fun main() {
    println("다리 건너기 게임을 시작합니다")
    playgame()
}
