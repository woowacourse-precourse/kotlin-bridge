package bridge

var retryCount = 1

fun gameCycleFirst(): List<String> {
    val bridgeLength = InputView().readBridgeSize()
    val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeLength)
    return bridge
}

fun gameCycleSecond(bridgeAnswer:List<String>): MutableList<String> {
    var currentMove : String
    val movedResult = mutableListOf<String>()
    for (current in bridgeAnswer){
        currentMove = InputView().readMoving()
        val afterMove = BridgeGame().move(current,currentMove)
        movedResult.add(afterMove)
        OutputView().printMap(bridgeAnswer,movedResult)
        if (afterMove=="X") break
    }
    return movedResult
}

fun gameCycleThird(bridgeAnswer: List<String>, movedResult : List<String>){
    if ("X" in movedResult){
        when (InputView().readGameCommand()){
            "R" -> {
                retryCount+=1
                BridgeGame().retry(bridgeAnswer)
            }
            "Q" -> OutputView().printResult(bridgeAnswer,movedResult, retryCount)
        }
    }
    else OutputView().printResult(bridgeAnswer,movedResult, retryCount)
}