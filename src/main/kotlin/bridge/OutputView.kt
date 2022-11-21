package bridge

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView(
    private val bridge: List<String>,
) {
    private var moveDirections = listOf<String>()
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap() {
        for (i in moveDirections.indices) {
            printTopLine(bridge[i], moveDirections[i], i)
        }
        for (i in moveDirections.indices) {
            printBottomLine(bridge[i], moveDirections[i], i)
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult() {
        println(FINAL_GAME_RESULT)
        printMap()
    }

    fun setMoveDirections(userMoveDirections: List<String>) {
        moveDirections = userMoveDirections
    }


    private fun printTopLine(bridgeDirection: String, moveDirection: String, index: Int) {
        if (moveDirection == Moving.UP.getMovDirection()) {
            printBridgeOneLine(bridgeDirection, moveDirection, index)
        } else if (moveDirection == Moving.DOWN.getMovDirection()) {
            printBridgeOneLine(bridgeDirection, BLANK, index)
        }
    }

    private fun printBottomLine(bridgeDirection: String, moveDirection: String, index: Int) {
        if (moveDirection == Moving.DOWN.getMovDirection()) {
            printBridgeOneLine(bridgeDirection, moveDirection, index)
        } else if (moveDirection == Moving.UP.getMovDirection()) {
            printBridgeOneLine(bridgeDirection, BLANK, index)
        }
    }


    private fun printBridgeOneLine(bridgeDirection: String, userDirection: String, count: Int) {
        if (count == ZERO_VALUE) {
            printBridgeHead(bridgeDirection, userDirection)
            if (moveDirections.size == ONE_VALUE) printBridgeEnd()
        } else {
            printBridgeMiddle(bridgeDirection, userDirection)
            if (moveDirections.size - ONE_VALUE == count) printBridgeEnd()
        }
    }


    private fun printBridgeHead(bridgeDirection: String, userDirection: String) {
        printBridgeStart()
        printBridgeBlank()
        when (userDirection) {
            bridgeDirection -> printMovingPossible()
            BLANK -> printBridgeBlank()
            else -> printMovingNotPossible()
        }
        printBridgeBlank()
    }

    private fun printBridgeMiddle(bridgeDirection: String, userDirection: String) {
        printBridgeDivision()
        printBridgeBlank()
        when (userDirection) {
            bridgeDirection -> printMovingPossible()
            BLANK -> printBridgeBlank()
            else -> printMovingNotPossible()
        }
        printBridgeBlank()
    }


    private fun printBridgeStart() {
        print(BRIDGE_START)
    }

    private fun printBridgeEnd() {
        print(BRIDGE_END)
        println()
    }

    private fun printBridgeDivision() {
        print(BRIDGE_DIVISION)
    }

    private fun printBridgeBlank() {
        print(BLANK)
    }

    private fun printMovingPossible() {
        print(MOVING_POSSIBLE)
    }

    private fun printMovingNotPossible() {
        print(MOVING_NOT_POSSIBLE)
    }


    companion object {
        const val BRIDGE_START = "["
        const val BRIDGE_END = "]"
        const val BRIDGE_DIVISION = "|"
        const val BLANK = " "
        const val MOVING_POSSIBLE = "O"
        const val MOVING_NOT_POSSIBLE = "X"
        const val ZERO_VALUE = 0
        const val ONE_VALUE = 1
        const val FINAL_GAME_RESULT = "최종 게임 결과"
    }
}
