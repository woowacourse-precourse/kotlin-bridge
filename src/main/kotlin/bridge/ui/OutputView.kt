package bridge.ui

import bridge.utils.*

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    private var map = mutableListOf("[ ]", "[ ]")

    fun initMap() {
        map = mutableListOf("[ ]", "[ ]")
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(column: Int, actual: String, predict: String): List<String> {
        if (column == 0) {
            handleFirstColumnCase(column, actual, predict)
        } else {
            handlePartitionCase(column, actual, predict)
        }
        return map
    }

    private fun handleFirstColumnCase(column: Int, actual: String, predict: String) {
        if (predict == UP) {
            if (predict == actual) printUpCorrectCase(column + 1)
            else printUpIncorrectCase(column + 1)
        } else {
            if (predict == actual) printDownCorrectCase(column + 1)
            else printDownIncorrectCase(column + 1)
        }
    }

    private fun handlePartitionCase(column: Int, actual: String, predict: String) {
        val index = 4 * column - 1
        if (predict == UP) {
            if (predict == actual) handleCorrectCase(UP, index)
            else handleIncorrectCase(UP, index)
        } else {
            if (predict == actual) handleCorrectCase(DOWN, index)
            else handleIncorrectCase(DOWN, index)
        }
    }

    private fun handleCorrectCase(direction: String, index: Int) {
        printPartition(index)
        if (direction == UP) {
            printUpCorrectCase(index + 2)
        } else {
            printDownCorrectCase(index + 2)
        }
    }

    private fun handleIncorrectCase(direction: String, index: Int) {
        printPartition(index)
        if (direction == UP) {
            printUpIncorrectCase(index + 2)
        } else {
            printDownIncorrectCase(index + 2)
        }
    }

    private fun printUpCorrectCase(index: Int) {
        map[0] = insertAtIndex(map[0], CORRECT, index)
        map[1] = insertAtIndex(map[1], "  ", index)
    }

    private fun printDownCorrectCase(index: Int) {
        map[0] = insertAtIndex(map[0], "  ", index)
        map[1] = insertAtIndex(map[1], CORRECT, index)
    }

    private fun printUpIncorrectCase(index: Int) {
        map[0] = insertAtIndex(map[0], INCORRECT, index)
        map[1] = insertAtIndex(map[1], "  ", index)
    }

    private fun printDownIncorrectCase(index: Int) {
        map[0] = insertAtIndex(map[0], "  ", index)
        map[1] = insertAtIndex(map[1], INCORRECT, index)
    }

    private fun printPartition(index: Int) {
        map[0] = insertAtIndex(map[0], PARTITION, index)
        map[1] = insertAtIndex(map[1], PARTITION, index)
    }

    private fun insertAtIndex(original: String, str: String, position: Int): String {
        val sb = StringBuilder(original)
        sb.insert(position, str)
        return sb.toString()
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(map: List<String>, result: String, tryNumber: Int) {
        println(FINAL_MAP_MSG)
        println(map[0])
        println(map[1])
        println(FINAL_RESULT_MSG + result)
        println(FINAL_TRY_NUM_MSG + tryNumber)
    }
}
