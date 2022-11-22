package bridge

import bridge.constants.Constants.BLANK_MARK
import bridge.constants.Constants.BRIDGE_END
import bridge.constants.Constants.BRIDGE_MIDDLE
import bridge.constants.Constants.BRIDGE_START
import bridge.constants.Constants.CORRECT_MARK
import bridge.constants.Constants.DOWN_BRIDGE_STRING
import bridge.constants.Constants.INCORRECT_MARK
import bridge.constants.Constants.UP_BRIDGE_STRING
import bridge.constants.PrintMessage.RESULT_COUNT
import bridge.constants.PrintMessage.RESULT_FAILURE
import bridge.constants.PrintMessage.RESULT_IS_SUCCESS
import bridge.constants.PrintMessage.RESULT_SUCCESS
import bridge.constants.PrintMessage.RESULT_TITLE

class OutputView(private val bridge: List<String>) {
    private val up = StringBuilder(BRIDGE_START)
    private val down = StringBuilder(BRIDGE_START)

    fun printMap(moving: List<String>) {
        for (position in moving.indices) {
            markAnswer(moving, position, moving[position] == bridge[position])
            if (moving[position] != bridge[position]) break
            if (position != moving.size - 1) addStringToMap(BRIDGE_MIDDLE, BRIDGE_MIDDLE)
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
        addStringToMap(BRIDGE_END, BRIDGE_END)
        println("$up\n$down\n")
        up.clear()
        down.clear()
        addStringToMap(BRIDGE_START, BRIDGE_START)
    }

    fun printResult(choice: List<String>, isSuccess: Boolean, count: Int) {
        val result = when (isSuccess) {
            true -> RESULT_SUCCESS
            false -> RESULT_FAILURE
        }
        println(RESULT_TITLE)
        printMap(choice)
        println("$RESULT_IS_SUCCESS$result")
        println("$RESULT_COUNT$count")
    }
}
