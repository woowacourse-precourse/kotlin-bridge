package bridge.view

class OutputView {
    fun printGameStart() {
        println(GAME_START_MESSAGE)
    }

    fun printMap(map: String) {
        println(map)
    }

    fun printResult(gameTryCount: Int, gameResultMessage: String, map: String) {
        println(GAME_END_MESSAGE)
        printMap(map)
        print(GAME_SUCCESS_OR_FAILURE_MESSAGE)
        println(gameResultMessage)
        println("$GAME_TRY_COUNT_MESSAGE$gameTryCount")
    }

    companion object {
        const val GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다."
        const val GAME_END_MESSAGE = "\n최종 게임 결과"
        const val GAME_SUCCESS_OR_FAILURE_MESSAGE = "\n게임 성공 여부: "
        const val GAME_TRY_COUNT_MESSAGE = "총 시도한 횟수: "
    }
}
