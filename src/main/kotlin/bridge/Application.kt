package bridgefun

import bridge.*

fun makeBridge(size: Int): List<String> {
    val bridge = mutableListOf<String>()
    var bridgeNumberGenerator: BridgeNumberGenerator = BridgeRandomNumberGenerator()
    var temp = 0
    for (i in 0 until size) {
        temp = bridgeNumberGenerator.generate()
        println(temp)
        if (temp == 0) {
            bridge.add("D")
        } else if (temp == 1) {
            bridge.add(("U"))
        }
    }
    return bridge
}

fun main() {
    var size = 0
    println(makeBridge(3))

    OutputView().printStartGame()

    OutputView().inputBridgeLength()

    size=InputView().readBridgeSize()

//    BridgeMaker(BridgeNumberGenerator).makeBridge(size)

    OutputView().chooseMove()

    InputView().readMoving()

}
