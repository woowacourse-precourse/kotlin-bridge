package bridge

fun BridgeGameMain(){
    var InputView = InputView()
    var size = -1
    while(size ==-1) {
        size = InputView.readBridgeSize()
    }
    var bridgeNumberGenerator = BridgeRandomNumberGenerator()
    var bridgeMaker = BridgeMaker(bridgeNumberGenerator)
    var bridge = bridgeMaker.makeBridge(size)
}

fun main() {
    print("다리건너기 게임을 시작합니다.")

}
