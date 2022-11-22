package bridge

import bridge.constants.Constants.DOWN_BRIDGE
import bridge.constants.Constants.UP_BRIDGE

class OutputView(private val bridge: List<String>) {
    private val up = StringBuilder()
    private val down = StringBuilder()

    fun printMap(moving: List<String>) {
        makeMap("[ ", "[ ")
        for (position in moving.indices) {
            if (moving[position] == bridge[position]) isCorrect(moving, position, true)
            else {
                isCorrect(moving, position, false)
                makeMap(" ]", " ]")
                break
            }
            if (position != moving.size - 1) makeMap(" | ", " | ")
            else makeMap(" ]", " ]")
        }
        print("$up\n$down\n\n")
    }

    private fun makeMap(upString: String, downString: String) {
        up.append(upString)
        down.append(downString)
    }

    private fun isCorrect(moving: List<String>, position: Int, correct: Boolean) {
        val str = if (correct) "O" else "X"
        if (moving[position] == bridge[position]) {
            when (bridge[position]) {
                UP_BRIDGE -> makeMap(str, " ")
                DOWN_BRIDGE -> makeMap(" ", str)
            }
        } else {
            when (bridge[position]) {
                UP_BRIDGE -> makeMap(" ", str)
                DOWN_BRIDGE -> makeMap(str, " ")
            }
        }
    }

    fun printResult(choice: List<String>, isSuccess: Boolean, count: Int) {
        val result = when (isSuccess) {
            true -> "성공"
            false -> "실패"
        }
        println("최종 게임 결과")
        printMap(choice)
        println("게임 성공 여부: $result")
        println("총 시도한 횟수: $count")
    }
}
