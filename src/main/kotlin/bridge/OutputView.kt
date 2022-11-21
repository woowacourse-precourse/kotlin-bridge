package bridge

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    private enum class Message(val sentence: String) {
        START("다리 건너기 게임을 시작합니다\n"),
        INPUT_BRIDGE_LENGTH("다리의 길이를 입력해주세요"),
        MOVE_UP_OR_DOWN("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
        RESTART_OR_NOT("게임을 다시 시도할지 여부를 입력해주세요 (재시도: R, 종료: Q)"),
        FINAL_RESULT("최종 게임 결과"),
        SUCCESS_OR_NOT("게임 성공 여부: "),
        TOTAL_TRY_NUMBER("총 시도한 횟수: "),
        BRIDGE_START("["),
        BRIDGE_END("]"),
        BRIDGE_PARITITION("|"),
        SUCCESS("성공"),
        FAIL("실패")
    }

    fun printStartMessage() {
        println(Message.START.sentence)
    }

    fun inputBridgeLength() {
        println(Message.INPUT_BRIDGE_LENGTH.sentence)
    }

    fun inputDirection() {
        println(Message.MOVE_UP_OR_DOWN.sentence)
    }

    fun inputRestartOrQuit() {
        println(Message.RESTART_OR_NOT.sentence)
    }

    fun printFinalResult() {
        println(Message.FINAL_RESULT.sentence)
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(upResult: List<String>, downResult: List<String>) {
        printLine(upResult)
        printLine(downResult)
        println()
    }

    private fun printLine(result: List<String>) {
        print(Message.BRIDGE_START.sentence)
        var i = 0
        while (i < result.size - 1) {
            print(result[i] + Message.BRIDGE_PARITITION.sentence)
            i++
        }
        print(result[result.size - 1])
        println(Message.BRIDGE_END.sentence)
    }

    fun printResult(success: Boolean, tryCount: Int) {
        if (success) {
            println(Message.SUCCESS_OR_NOT.sentence + Message.SUCCESS.sentence)
        }
        if (!success) {
            println(Message.SUCCESS_OR_NOT.sentence + Message.FAIL.sentence)
        }
        println(Message.TOTAL_TRY_NUMBER.sentence + tryCount.toString())
    }

    fun printError(message: String) {
        println(message)
    }
}
