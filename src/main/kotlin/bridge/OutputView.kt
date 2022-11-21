package bridge

class OutputView {

    fun printStartMessage() {
        println(START_GAME_MESSAGE)
    }

    fun printMap(result: Result) {
        val firstRowResult = result.getFirstRowResult()
        val secondRowResult = result.getSecondRowResult()
        println(firstRowResult.joinToString(prefix = PREFIX, separator = SEPARATOR, postfix = POSTFIX))
        println(secondRowResult.joinToString(prefix = PREFIX, separator = SEPARATOR, postfix = POSTFIX))
    }

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
        const val PREFIX = "[ "
        const val SEPARATOR = " | "
        const val POSTFIX = " ]"
    }
}
