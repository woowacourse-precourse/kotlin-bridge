package bridge

fun BridgeGameMain(){
    var InputView = InputView()
    var a = -1
    while(a ==-1) {
        a = InputView.readBridgeSize()
    }
}

fun main() {
    print("다리건너기 게임을 시작합니다.")

}
