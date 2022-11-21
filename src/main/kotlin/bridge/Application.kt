package bridge

fun main() {
    // TODO: 프로그램 구현
    println("다리 건너기 게임을 시작합니다.\n")
    val input=InputView()
    val generator=BridgeRandomNumberGenerator()
    val maker=BridgeMaker(generator)
    val bridge=maker.makeBridge(input.readBridgeSize())
    println(bridge)
    println()
    val gameManager= BridgeGame(bridge,Bridge(mutableListOf<String>(),InputView(),OutputView()),Status())
    gameManager.play()
}
