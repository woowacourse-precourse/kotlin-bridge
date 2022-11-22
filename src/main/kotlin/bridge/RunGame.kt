package bridge

class RunGame {
    private var regame = ""
    private var tryCount = 1
    private var loop = true

    fun gameMaker(bridge: List<String>){
        while (loop) {
            val caseList = mutableListOf<Int>()
            val answer = caseMaker(bridge, caseList)
            if (!answer)
                wrongChoice(caseList)
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

    fun wrongChoice(caseList: MutableList<Int>){
        regame = InputView().readGameCommand()
        if (!BridgeGame().retry(regame)) {
            regame = ""
            tryCount += 1
        }
        if (BridgeGame().retry(regame)) {
            OutputView().printResult(false, caseList, tryCount)
            loop = true
        }
    }
}