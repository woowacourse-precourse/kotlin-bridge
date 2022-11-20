package bridge

fun main() {
    // TODO: 프로그램 구현
    val bridgeSize = InputView().readBridgeSize()
    val bridgeMade = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSize)

    var caseList = mutableListOf<Int>()
    var answer = true
    var regame = ""
    while(true){
        for (i in bridgeMade.indices) {
            val case = BridgeGame().move(bridgeMade[i], InputView().readMoving())
            caseList.add(case)
            OutputView().printMap(caseList)
            if (case == 3 || case == 4) {
                answer = false
                break

            }
            if (i == bridgeMade.size - 1){
                answer = true
                break
            }
        }
        if (!answer) {
            regame = InputView().readGameCommand()
            println(regame)
        }
    }
}
