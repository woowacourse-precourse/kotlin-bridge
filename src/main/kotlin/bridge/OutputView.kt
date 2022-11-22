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
        println(OutputMessage.GAME_RESULT.message)
        printMap(caseList)
        if (answer)
            println(OutputMessage.GAME_SUCCESS.message)
        if (!answer)
            println(OutputMessage.GAME_FAIL.message)
        print(OutputMessage.GAME_COUNT.message)
        println("$tryCount")
    }

    fun correctAnswer(case: Int) {
        if (case == 1) {
            upBridge.add(BridgePoint.POINT_PASS.point)
            downBridge.add(BridgePoint.POINT_EMPTY.point)
        }
        if (case == 2) {
            upBridge.add(BridgePoint.POINT_EMPTY.point)
            downBridge.add(BridgePoint.POINT_PASS.point)
        }
    }


    fun wrongAnswer(case: Int) {
        if (case == 3) {
            upBridge.add(BridgePoint.POINT_WRONG.point)
            downBridge.add(BridgePoint.POINT_EMPTY.point)
        }
        if (case == 4) {
            upBridge.add(BridgePoint.POINT_EMPTY.point)
            downBridge.add(BridgePoint.POINT_WRONG.point)
        }
    }

    fun bridgePrint(list: List<String>): String {
        var string = BridgePoint.POINT_START.point
        for (element in list) {
            string = string.plus(element)
            string = string.plus(BridgePoint.POINT_MIDDLE.point)
        }
        string = string.substring(0, string.length - 1)
        string = string.plus(BridgePoint.POINT_END.point)
        return string
    }

    enum class OutputMessage(val message: String){
        GAME_RESULT("최종 게임 결과"),
        GAME_SUCCESS("게임 성공 여부: 성공"),
        GAME_FAIL("게임 성공 여부: 실패"),
        GAME_COUNT("총 시도한 횟수: ")
    }

    enum class BridgePoint(val point: String){
        POINT_PASS(" O "),
        POINT_WRONG(" X "),
        POINT_EMPTY("   "),
        POINT_START("["),
        POINT_MIDDLE("|"),
        POINT_END("]")
    }
}
