package bridge

class Judgement {
    private val bridgeNumberGenerator = BridgeRandomNumberGenerator()
    private var correctBridgeMap = mutableListOf<String>()

    fun createCorrectBridge(size : Int) {
        correctBridgeMap.clear()
        correctBridgeMap = BridgeMaker(bridgeNumberGenerator).makeBridge(size).toMutableList()
    }

    fun judgeMovingSuccess(currentMoving : List<String>) : Boolean{
        return currentMoving.last()==correctBridgeMap[currentMoving.lastIndex]
    }

    fun checkGameOver(currentMoving: List<String>) : Boolean{
        var result = false
        if(!judgeMovingSuccess(currentMoving) || currentMoving.lastIndex==correctBridgeMap.size-1){
            result = true
        }
        return result
    }
}