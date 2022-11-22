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
        println(bridgePrint(upBridge))
        println(bridgePrint(downBridge))
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(answer: Boolean, caseList: List<Int>, tryCount: Int) {
        println(GAME_RESULT)
        printMap(caseList)
        if (answer)
            println(GAME_SUCCESS)
        if (!answer)
            println(GAME_FAIL)
        println("$GAME_COUNT$tryCount")
    }

    fun correctAnswer(case: Int) {
        if (case == 1) {
            upBridge.add(POINT_PASS)
            downBridge.add(POINT_EMPTY)
        }
        if (case == 2) {
            upBridge.add(POINT_EMPTY)
            downBridge.add(POINT_PASS)
        }
    }


    fun wrongAnswer(case: Int) {
        if (case == 3) {
            upBridge.add(POINT_WRONG)
            downBridge.add(POINT_EMPTY)
        }
        if (case == 4) {
            upBridge.add(POINT_EMPTY)
            downBridge.add(POINT_WRONG)
        }
    }

    fun bridgePrint(list: List<String>): String {
        var string = POINT_START
        for (element in list) {
            string = string.plus(element)
            string = string.plus(POINT_MIDDLE)
        }
        string = string.substring(0, string.length - 1)
        string = string.plus(POINT_END)
        return string
    }
}
