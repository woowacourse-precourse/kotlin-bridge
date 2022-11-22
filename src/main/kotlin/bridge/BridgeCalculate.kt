package bridge


object BridgeCalculate {

    fun bridgeMoving(bridge: List<String>, count: Int): Boolean {
        OutputView.getBridgeMoving()
        return bridge[count] == InputView.readMoving()
    }


    fun upLine(bridge: List<String>, successRecord: List<Boolean>): String {
        var upLineMap = BridgeMessage.MapStart.word
        for (count: Int in BridgeParameter.StartValue.value until successRecord.size) {
            upLineMap += when {
                bridge[count] == BridgeMessage.Up.word && successRecord[count] -> BridgeMessage.WALK_AND_PASS.word
                (bridge[count] == BridgeMessage.Up.word && !successRecord[count]) || (bridge[count] == BridgeMessage.Down.word && successRecord[count]) -> BridgeMessage.DO_NOT_WALK.word
                else -> BridgeMessage.WALK_AND_FAIL.word
            }
        }
        return mapEnd(upLineMap)
    }

    fun downLine(bridge: List<String>, successRecord: List<Boolean>): String {
        var downLineMap = BridgeMessage.MapStart.word
        for (count: Int in BridgeParameter.StartValue.value until successRecord.size) {
            downLineMap += when {
                bridge[count] == BridgeMessage.Down.word && successRecord[count] -> BridgeMessage.WALK_AND_PASS.word
                (bridge[count] == BridgeMessage.Down.word && !successRecord[count]) || (bridge[count] == BridgeMessage.Up.word && successRecord[count]) -> BridgeMessage.DO_NOT_WALK.word
                else -> BridgeMessage.WALK_AND_FAIL.word
            }
        }
        return mapEnd(downLineMap)
    }

    private fun mapEnd(map: String) = map.substring(
        BridgeParameter.StartValue.value,
        map.length - BridgeParameter.LastCharCut.value
    ) + BridgeMessage.MapEnd.word

}