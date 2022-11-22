package bridge

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView(private val bridge: List<String>) {
    private val validationInput = ValidationInput()
    private var wrongStatus = 0
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(movingRecord: List<String>) {
        val map = getMap(movingRecord)

        printOneSideBridge(map[0])   // upsideBridge
        printOneSideBridge(map[1])   // downsideBridge
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

    private fun makeBridgePicture (movingRecord: List<String>): List<MutableList<String>> {
        val upsideBridge = mutableListOf<String>()
        val downsideBridge = mutableListOf<String>()

        addBridgeBeginning(upsideBridge, downsideBridge)
        addBridgeMiddle(upsideBridge, downsideBridge, movingRecord)
        addBridgeEnd(upsideBridge, downsideBridge)

        return listOf(upsideBridge, downsideBridge)
    }


    private fun getMap(movingRecord: List<String>): List<MutableList<String>> {
        val map = makeBridgePicture(movingRecord)

        if (movingRecord.isEmpty()) {
            clearBridgePicture(map)
            wrongStatus = 0
        }
        return map
    }

    private fun clearBridgePicture(bridgePicture: List<MutableList<String>>) {
        for (i in bridgePicture.indices) bridgePicture[i].clear()
    }

    private fun addBridgeBeginning (
            upsideBridge: MutableList<String>,
            downsideBridge: MutableList<String>
    ) {
        upsideBridge.add(BRIDGE_BEGINNING)
        downsideBridge.add(BRIDGE_BEGINNING)
    }

    private fun addBridgeBoundary(bridge: MutableList<String>, round: Int, count: Int) {
        if (round != 1 && count != round) bridge.add(BRIDGE_BOUNDARY)
    }

    private fun addBridgeMiddle(
            upsideBridge: MutableList<String>,
            downsideBridge: MutableList<String>,
            movingRecord: List<String>
    ) {
        val round = movingRecord.size

        for (i in 1..round) {
            if (movingRecord[i - 1] == bridge[i - 1])
                addBridgeCorrectBlock(movingRecord[i - 1], upsideBridge, downsideBridge)
            else {
                addBridgeWrongBlock(movingRecord[i - 1], upsideBridge, downsideBridge)
                wrongStatus = 1
            }
            addBridgeBoundary(upsideBridge, round, i)
            addBridgeBoundary(downsideBridge, round, i)
        }
    }

    private fun addBridgeEnd(
            upsideBridge: MutableList<String>,
            downsideBridge: MutableList<String>
    ) {
        upsideBridge.add(BRIDGE_END)
        downsideBridge.add(BRIDGE_END)
    }
    
    private fun addBridgeCorrectBlock(
            movingDirection: String,
            upsideBridge: MutableList<String>,
            downsideBridge: MutableList<String>
    ) {
        when (movingDirection) {
            validationInput.getUpDirectionValue() ->
            {
                upsideBridge.add(RIGHT_ANSWER)
                downsideBridge.add(NO_INPUT)
            }
            validationInput.getDownDirectionValue() ->
            {
                upsideBridge.add(NO_INPUT)
                downsideBridge .add(RIGHT_ANSWER)
            }
        }
    }

    private fun addBridgeWrongBlock(
            movingDirection: String,
            upsideBridge: MutableList<String>,
            downsideBridge: MutableList<String>
    ) {
        when (movingDirection) {
            validationInput.getUpDirectionValue() ->
            {
                upsideBridge.add(WRONG_ANSWER)
                downsideBridge.add(NO_INPUT)
            }

            validationInput.getDownDirectionValue() ->
            {
                upsideBridge.add(NO_INPUT)
                downsideBridge.add(WRONG_ANSWER)
            }
        }
    }

    fun getWrongStatus() = wrongStatus

    fun getBridge() = bridge

    companion object {
        const val BRIDGE_BEGINNING = "["
        const val BRIDGE_END = "]"
        const val BRIDGE_BOUNDARY = "|"
        const val NO_INPUT = "   "
        const val RIGHT_ANSWER = " O "
        const val WRONG_ANSWER = " X "
    }
}
