package bridge

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    var upBridge = mutableListOf<String>()
    var downBridge = mutableListOf<String>()
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(caseList: List<Int>) {
        for (i in caseList.indices) {
            if (caseList[i] == 1 || caseList[i] == 2)
                correctAnswer(caseList[i])
            if (caseList[i] == 3 || caseList[i] == 4)
                wrongAnswer(caseList[i])
        }
        println(pprint(upBridge))
        println(pprint(downBridge))
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult() {}


    fun correctAnswer(case: Int) {
        if (case == 1) {
            upBridge.add(" O ")
            downBridge.add("   ")
        }
        if (case == 2) {
            upBridge.add("   ")
            downBridge.add(" O ")
        }
    }


    fun wrongAnswer(case: Int) {
        if (case == 3) {
            upBridge.add(" X ")
            downBridge.add("   ")
        }
        if (case == 4) {
            upBridge.add("   ")
            downBridge.add(" X ")
        }
    }
    fun pprint(list: List<String>): String {
        var string = "["
        for (element in list) {
            string = string.plus(element)
            string = string.plus("|")
        }
        string = string.substring(0, string.length - 1)
        string = string.plus("]")
        return string
    }
}
