package bridge.view

class OutputView {
    fun printStart() {
        println(GAME_START)
    }

    fun printMap(map: List<List<String>>) {
        map.forEach {
            print(MAP_START)
            print(it.joinToString(MAP_SEPARATOR))
            println(MAP_END)
        }
    }

    fun printResult(map: List<List<String>>, result: String, numOfTry: Int) {
        println(GAME_RESULT)
        printMap(map)
        println("\n${GAME_SUCCESS}${result}")
        println("${GAME_TRY}${numOfTry}")
    }

    companion object {
        const val MAP_START = "[ "
        const val MAP_SEPARATOR = " | "
        const val MAP_END = " ]"

        const val GAME_START = "다리 건너기 게임을 시작합니다.\n"
        const val GAME_RESULT = "\n최종 게임 결과"
        const val GAME_SUCCESS = "게임 성공 여부: "
        const val GAME_TRY = "총 시도한 횟수: "
        const val RESULT_SUCCESS = "성공"
        const val RESULT_FAIL = "실패"
    }
}
