package bridge

fun main() {
    val input=InputView()
    val output=OutputView()

    println("다리 건너기 게임을 시작합니다.\n")
    val bridgeGame = BridgeGame(BridgeMaker(BridgeRandomNumberGenerator()), input.readBridgeSize())

}




