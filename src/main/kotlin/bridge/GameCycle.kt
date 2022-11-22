package bridge
fun gameCycleFirst(): List<String> {
    val bridgeLength = InputView().readBridgeSize()
    val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeLength)
    return bridge
}

fun gameCycleSecond(bridgeAnswer:List<String>): MutableList<String> {
    val movedResult = mutableListOf<String>()
    for (current in bridgeAnswer){
        val currentMove = InputView().readMoving()
        movedResult.add(BridgeGame().move(current,currentMove))
        OutputView().printMap(bridgeAnswer,movedResult)
        if ("X" in movedResult) break
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