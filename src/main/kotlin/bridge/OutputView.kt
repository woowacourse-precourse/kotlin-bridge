package bridge

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    private val input = InputView()
    private val randomNumberGenerator = BridgeRandomNumberGenerator()
    private val bridgeMaker = BridgeMaker(randomNumberGenerator)
    private val bridge = bridgeMaker.makeBridge(input.readBridgeSize())
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(movingRecord: List<String>) {
        val bridgePicture = makeBridgePicture(movingRecord)

        printOneSideBridge(bridgePicture[0])   // upsideBridge
        printOneSideBridge(bridgePicture[1])   // downsideBridge
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult() {}

    private fun printOneSideBridge(list: List<String>) {
        for (i in list.indices) print(list[i])
        println("")
    }

    private fun makeBridgePicture (movingRecord: List<String>): List<List<String>> {
        val upsideBridge = mutableListOf<String>()
        val downsideBridge = mutableListOf<String>()

        addBridgeBeginning(upsideBridge, downsideBridge)
        addBridgeMiddle(upsideBridge, downsideBridge, movingRecord)
        addBridgeEnd(upsideBridge, downsideBridge)

        return listOf(upsideBridge.toList(), downsideBridge.toList())
    }

    private fun addBridgeBeginning (
            upsideBridge: MutableList<String>,
            downsideBridge: MutableList<String>
    ) {
        upsideBridge.add(BRIDGE_BEGINNING)
        downsideBridge.add(BRIDGE_BEGINNING)
    }

    private fun addBridgeMiddle(
            upsideBridge: MutableList<String>,
            downsideBridge: MutableList<String>,
            movingRecord: List<String>
    ) {
        val round = movingRecord.size

        for (count in 1..round) {
            if (movingRecord[count - 1] == bridge[count - 1])
                addBlockRightAnswer(movingRecord[count - 1], upsideBridge, downsideBridge)
            else
                addBlockWrongAnswer(movingRecord[count - 1], upsideBridge, downsideBridge)
            addBlockBoundary(upsideBridge, round, count)
            addBlockBoundary(downsideBridge, round, count)
        }
    }

    private fun addBridgeEnd(
            upsideBridge: MutableList<String>,
            downsideBridge: MutableList<String>
    ) {
        upsideBridge.add(BRIDGE_END)
        downsideBridge.add(BRIDGE_END)
    }

    private fun addBlockBoundary(block: MutableList<String>, round: Int, count: Int) {
        if (round != 1 && count != round) block.add("|")
    }

    private fun addBlockRightAnswer(
            movingDirection: String,
            upsideBridge: MutableList<String>,
            downsideBridge: MutableList<String>
    ) {
        when (movingDirection) {
            "U" -> {
                upsideBridge.add(RIGHT_ANSWER)
                downsideBridge.add(NO_INPUT)
            }

            "D" -> {
                upsideBridge.add(NO_INPUT)
                downsideBridge .add(RIGHT_ANSWER)
            }
        }
    }

    private fun addBlockWrongAnswer(
            movingDirection: String,
            upsideBridge: MutableList<String>,
            downsideBridge: MutableList<String>
    ) {
        when (movingDirection) {
            "U" -> {
                upsideBridge.add(WRONG_ANSWER)
                downsideBridge.add(NO_INPUT)
            }

            "D" -> {
                upsideBridge.add(NO_INPUT)
                downsideBridge .add(WRONG_ANSWER)
            }
        }
    }

    companion object {
        const val BRIDGE_BEGINNING = "["
        const val BRIDGE_END = "]"
        const val NO_INPUT = "   "
        const val RIGHT_ANSWER = " o "
        const val WRONG_ANSWER = " x "
    }
}
