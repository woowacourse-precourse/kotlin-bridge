package bridge

fun main() {
    println("다리 건너기 게임을 시작합니다.\n")

    val inputView = InputView()
    var bridgeLength = inputView.readBridgeSize()

    val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
    val answerBridge = bridgeMaker.makeBridge(bridgeLength)

    var whereToMove = InputView().readMoving()
    var inputBridge = listOf<String>()
    var success = true

    inputBridge = inputBridge.plus(whereToMove)
    var inputBridgeMutable = inputBridge.toMutableList()

    inputBridge.forEachIndexed { index, it ->
        if (answerBridge[index] != it) {
            success = false
            inputBridgeMutable[index] = it + "X"
            inputBridge = inputBridgeMutable.toList()
        }
    }

    var outputView = OutputView()
    outputView.printMap(inputBridge)

}
