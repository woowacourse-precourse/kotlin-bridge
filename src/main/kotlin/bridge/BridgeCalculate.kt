package bridge

const val WALK_AND_PASS = " O |"
const val DO_NOT_WALK = "   |"
const val WALK_AND_FAIL = " X |"

object BridgeCalculate {

    fun bridgeMoving(bridge: List<String>, count: Int): Boolean {
        OutputView.getBridgeMoving()
        return bridge[count] == InputView.readMoving()
    }


    fun upLine(bridge: List<String>, successRecord: List<Boolean>): String {
        var upLineMap = BridgeMessage.MapStart.word
        for (count: Int in BridgeParameter.StartValue.value until successRecord.size) {
            upLineMap += when {
                bridge[count] == BridgeMessage.Up.word && successRecord[count] -> WALK_AND_PASS
                (bridge[count] == BridgeMessage.Up.word && !successRecord[count]) || (bridge[count] == BridgeMessage.Down.word && successRecord[count]) -> DO_NOT_WALK
                else -> WALK_AND_FAIL
            }
        }
        return mapEnd(upLineMap)
    }

    fun downLine(bridge: List<String>, successRecord: List<Boolean>): String {
        var downLineMap = BridgeMessage.MapStart.word
        for (count: Int in BridgeParameter.StartValue.value until successRecord.size) {
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