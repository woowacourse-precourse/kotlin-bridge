package bridge

import bridge.constants.Constants.BLANK_MARK
import bridge.constants.Constants.CORRECT_MARK
import bridge.constants.Constants.DOWN_BRIDGE_STRING
import bridge.constants.Constants.INCORRECT_MARK
import bridge.constants.Constants.UP_BRIDGE_STRING

class OutputView(private val bridge: List<String>) {
    private val up = StringBuilder("[ ")
    private val down = StringBuilder("[ ")

    fun printMap(moving: List<String>) {
        for (position in moving.indices) {
            markAnswer(moving, position, moving[position] == bridge[position])
            if (moving[position] == bridge[position]) break
            if (position != moving.size - 1) addStringToMap(" | ", " | ")
        }
        printStringBuilder()
    }

    private fun addStringToMap(upString: String, downString: String) {
        up.append(upString)
        down.append(downString)
    }

    private fun markAnswer(moving: List<String>, position: Int, isCorrect: Boolean) {
        val mark = if (isCorrect) CORRECT_MARK else INCORRECT_MARK
        if (moving[position] == bridge[position]) {
            if (bridge[position] == UP_BRIDGE_STRING) addStringToMap(mark, BLANK_MARK)
            if (bridge[position] == DOWN_BRIDGE_STRING) addStringToMap(BLANK_MARK, mark)
        } else {
            if (bridge[position] == UP_BRIDGE_STRING) addStringToMap(BLANK_MARK, mark)
            if (bridge[position] == DOWN_BRIDGE_STRING) addStringToMap(mark, BLANK_MARK)
        }
    }

    private fun printStringBuilder() {
        addStringToMap(" ]", " ]")
        print("$up\n$down\n\n")
        up.clear()
        down.clear()
        addStringToMap("[ ", "[ ")
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
