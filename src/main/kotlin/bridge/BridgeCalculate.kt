package bridge

const val WALK_AND_PASS = " O |"
const val DO_NOT_WALK = "   |"
const val WALK_AND_FAIL = " X |"

object BridgeCalculate {

    fun bridgeMaking(size: Int): List<Int> {
        val bridge = mutableListOf<Int>()
        val randomizer = BridgeRandomNumberGenerator()
        for (number: Int in 0..size)
            bridge.add(randomizer.generate())

        return bridge.toList()
    }

    fun bridgeMoving(bridge: List<Int>, count: Int): Boolean {
        OutputView.getBridgeMoving()
        return bridge[count] == InputView.readMoving()
    }

    fun bridgeMapPrint(bridge: List<Int>, record: List<Boolean>) {
        OutputView.printMap(upLine(bridge, record))
        OutputView.printMap(downLine(bridge, record))

    }

    private fun upLine(bridge: List<Int>, successRecord: List<Boolean>): String {
        var upLineMap = BridgeMessage.MapStart.word
        for (count: Int in BridgeParameter.StartValue.value..successRecord.size) {
            upLineMap += when {
                bridge[count] == BridgeParameter.Up.value && successRecord[count] -> WALK_AND_PASS
                (bridge[count] == BridgeParameter.Up.value && !successRecord[count]) || (bridge[count] == BridgeParameter.Down.value && successRecord[count]) -> DO_NOT_WALK
                else -> WALK_AND_FAIL
            }
        }
        upLineMap = upLineMap.substring(BridgeParameter.StartValue.value,upLineMap.length - BridgeParameter.LastCharCut.value)
        return  upLineMap+ BridgeMessage.MapEnd.word
    }

    private fun downLine(bridge: List<Int>, successRecord: List<Boolean>): String {
        var downLineMap = BridgeMessage.MapStart.word
        for (count: Int in BridgeParameter.StartValue.value..successRecord.size) {
            downLineMap += when {
                bridge[count] == BridgeParameter.Down.value && successRecord[count] -> WALK_AND_PASS
                (bridge[count] == BridgeParameter.Down.value && !successRecord[count]) || (bridge[count] == BridgeParameter.Up.value && successRecord[count]) -> DO_NOT_WALK
                else -> WALK_AND_FAIL
            }
        }
        return downLineMap.substring(
            BridgeParameter.StartValue.value,
            downLineMap.length - BridgeParameter.LastCharCut.value
        ) + BridgeMessage.MapEnd.word
    }
}