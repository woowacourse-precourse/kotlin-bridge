package bridge

const val WALK_AND_PASS = " O |"
const val DO_NOT_WALK = "   |"
const val WALK_AND_FAIL = " X |"

object BridgeCalculate {

    fun bridgeMaking(size: Int): List<String> {
        val bridge = mutableListOf<String>()
        val randomizer = BridgeRandomNumberGenerator()
        for (number: Int in BridgeParameter.StartValue.value..size-1)
            bridge.add(numbertoBridge(randomizer.generate()))

        return bridge.toList()
    }

    fun numbertoBridge(number: Int): String {
        if (number == BridgeParameter.Up.value)
            return BridgeMessage.Up.word
        return BridgeMessage.Down.word
    }

    fun bridgeMoving(bridge: List<String>, count: Int): Boolean {
        OutputView.getBridgeMoving()
        return bridge[count] == InputView.readMoving()
    }

    fun bridgeMapPrint(bridge: List<String>, record: List<Boolean>) {
        OutputView.printMap(upLine(bridge, record))
        OutputView.printMap(downLine(bridge, record))

    }

    private fun upLine(bridge: List<String>, successRecord: List<Boolean>): String {
        var upLineMap = BridgeMessage.MapStart.word
        for (count: Int in BridgeParameter.StartValue.value..successRecord.size-1) {
            upLineMap += when {
                bridge[count] == BridgeMessage.Up.word && successRecord[count] -> WALK_AND_PASS
                (bridge[count] == BridgeMessage.Up.word && !successRecord[count]) || (bridge[count] == BridgeMessage.Down.word && successRecord[count]) -> DO_NOT_WALK
                else -> WALK_AND_FAIL
            }
        }
        return mapEnd(upLineMap)
    }

    private fun downLine(bridge: List<String>, successRecord: List<Boolean>): String {
        var downLineMap = BridgeMessage.MapStart.word
        for (count: Int in BridgeParameter.StartValue.value..successRecord.size-1) {
            downLineMap += when {
                bridge[count] == BridgeMessage.Down.word && successRecord[count] -> WALK_AND_PASS
                (bridge[count] == BridgeMessage.Down.word && !successRecord[count]) || (bridge[count] == BridgeMessage.Up.word && successRecord[count]) -> DO_NOT_WALK
                else -> WALK_AND_FAIL
            }
        }
        return mapEnd(downLineMap)
    }

    private fun mapEnd(map: String) = map.substring(
        BridgeParameter.StartValue.value,
        map.length - BridgeParameter.LastCharCut.value
    ) + BridgeMessage.MapEnd.word

}