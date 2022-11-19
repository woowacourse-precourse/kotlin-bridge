package bridge

fun playgame(){
    val bridge = buildBridge()
    var mybridge = mutableListOf<String>()

    while(mybridge.size != bridge.size){
        val temp = InputView().readMoving()
        BridgeGame().move(mybridge,temp)
        //출력도 해줘야 함 + 리겜 기능
    }

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
