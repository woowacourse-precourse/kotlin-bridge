package bridge

fun main() {
    // TODO: 프로그램 구현
    val bridgeSize = InputView().readBridgeSize()
    val bridgeMade = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSize)
    var answer: Boolean
    var regame = ""

    while (true) {
        var caseList = mutableListOf<Int>()
        answer = caseMaker(bridgeMade, caseList)
        //맞추기 틀린 경우
        if (!answer) {
            regame = InputView().readGameCommand()
        }
        //틀리고 재시작시 Q가 들어온 경우
        if (!answer && BridgeGame().retry(regame)) {
            break
        }
        //틀리고 재시작시 R이 들어온 경우
        if (!answer && !BridgeGame().retry(regame)) {
            regame = ""
        }
        //맞추기 성공한 경우
        if (answer) {
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