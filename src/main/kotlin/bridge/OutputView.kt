package bridge

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {

    fun printStartMessage() {
        println(START_GAME_MESSAGE)
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(result: Result) {
        val firstRowResult = result.getFirstRowResult()
        val secondRowResult = result.getSecondRowResult()
        println(firstRowResult.joinToString(prefix = "[ ", separator = " | ", postfix = " ]"))
        println(secondRowResult.joinToString(prefix = "[ ", separator = " | ", postfix = " ]"))
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(result: Result) {
        println(FINAL_RESULT_MESSAGE)
        printMap(result)
        var successOrFail = FAIL
        if (result.getSuccess()) {
            successOrFail = SUCCESS
        }
        println(SUCCESS_RESULT.format(successOrFail))
        println(TRY_COUNT_RESULT.format(result.getTryCount()))
    }

    companion object {
        const val START_GAME_MESSAGE = "다리 건너기 게임을 시작합니다."
        const val FINAL_RESULT_MESSAGE = "최종 게임 결과"
        const val FAIL = "실패"
        const val SUCCESS = "성공"
        const val SUCCESS_RESULT = "게임 성공 여부: %s"
        const val TRY_COUNT_RESULT = "총 시도한 횟수: %d"
    }
}
