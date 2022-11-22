package view

class OutputView {

    fun printGameStartNotification() {
        println(GAME_START_NOTIFICATION)
    }

    fun printMap(ox: List<MutableList<String>>) {
        printGameResult(ox)
    }

    fun printResult(ox: List<MutableList<String>>, count: Int, isSuccesss: String) {
        var isSuccess = SUCCESS
        if (isSuccesss == FAIL_ENGLISH) {
            isSuccess = FAIL
        }
        println(FINAL_GAME_RESULT)
        printGameResult(ox)
        println("$IS_SUCCESS $isSuccess")
        println("$TOTAL_ATTEMPT $count")
    }

    private fun printGameResult(ox: List<MutableList<String>>) {
        for (i in 0..1) {
            print("$LEFT_SQUARE_BRACKETS ")
            print(
                ox[i].toString().replace(REST, SEPARATOR).removePrefix(LEFT_SQUARE_BRACKETS)
                    .removeSuffix(RIGHT_SQUARE_BRACKETS)
            )
            print(" $RIGHT_SQUARE_BRACKETS")
            println()
        }
        println()
    }

    companion object {
        const val GAME_START_NOTIFICATION = "다리 건너기 게임을 시작합니다.\n"
        const val SUCCESS = "성공"
        const val FAIL = "실패"
        const val FAIL_ENGLISH = "FAIL"
        const val FINAL_GAME_RESULT = "최종 게임 결과"
        const val IS_SUCCESS = "게임 성공 여부:"
        const val TOTAL_ATTEMPT = "총 시도한 횟수:"
        const val LEFT_SQUARE_BRACKETS = "["
        const val RIGHT_SQUARE_BRACKETS = "]"
        const val REST = ","
        const val SEPARATOR = " |"
    }
}
