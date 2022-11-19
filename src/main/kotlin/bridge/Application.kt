package bridge

fun playgame(){
    val bridge = buildBridge()


}
fun buildBridge(): List<String>{
    val length = InputView().readBridgeSize()
    val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
    val bridge: List<String> = bridgeMaker.makeBridge(length)

    return bridge
}
fun main() {

}
