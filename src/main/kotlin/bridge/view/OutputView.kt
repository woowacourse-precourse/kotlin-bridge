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

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult() {}

    companion object {
        const val MAP_START = "[ "
        const val MAP_SEPARATOR = " | "
        const val MAP_END = " ]"

        const val GAME_START = "다리 건너기 게임을 시작합니다.\n"
        const val GAME_RESULT = "최종 게임 결과"
        const val GAME_SUCCESS = "게임 성공 여부: "
        const val GAME_TRY = "총 시도한 횟수: "
    }
}
