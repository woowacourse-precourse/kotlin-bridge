package bridge

fun main() {
    // TODO: 프로그램 구현
    val bridgeSize = InputView().readBridgeSize()
    val bridgeMade = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSize)

    var caseList = mutableListOf<Int>()
    for (i in bridgeMade.indices) {
        val case = BridgeGame().move(bridgeMade[i], InputView().readMoving())
        caseList.add(case)
        OutputView().printMap(caseList)
    }

}
