package bridge

fun main() {
    // TODO: 프로그램 구현
    val gen = BridgeRandomNumberGenerator()
    BridgeMaker(gen).makeBridge(InputView().readBridgeSize())

}
