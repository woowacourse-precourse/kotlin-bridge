package bridge

fun main() {

    val outputView = OutputView()
    val inputView = InputView()

    // 게임 시작 메시지 출력
    println(outputView.printStart())

    // 다리 길이 입력
    println(outputView.printBridgeSize())
    val bridgeSize = inputView.readBridgeSize()
    println("$bridgeSize\n")



}
