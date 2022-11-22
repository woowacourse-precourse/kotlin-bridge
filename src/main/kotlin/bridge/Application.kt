package bridge


fun main() {
    // TODO: 프로그램 구현
    val bridgeMade = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(InputView().readBridgeSize())
    gameMaker(bridgeMade)
}

fun gameMaker(bridge: List<String>){
    var regame = ""
    var tryCount = 1
    while (true) {
        val caseList = mutableListOf<Int>()
        val answer = caseMaker(bridge, caseList)
        if (!answer)
            regame = InputView().readGameCommand()
        if (!answer && BridgeGame().retry(regame)) {
            OutputView().printResult(false, caseList, tryCount)
            break
        }
        if (!answer && !BridgeGame().retry(regame)) {
            regame = ""
            tryCount += 1
        }
        if (answer) {
            OutputView().printResult(true, caseList, tryCount)
            break
        }
    }
}

fun caseMaker(bridge: List<String>, caseList: MutableList<Int>): Boolean {
    for (i in bridge.indices) {
        val case = BridgeGame().move(bridge[i], InputView().readMoving())
        caseList.add(case)
        OutputView().printMap(caseList)
        if (case == 3 || case == 4)
            break
        if (i == bridge.size - 1)
            return true
    }
    return false
}