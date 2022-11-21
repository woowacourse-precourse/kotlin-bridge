package bridge

fun main() {
    OutputView().printGameStartMessage()
    val size = InputView().readBridgeSize()
    val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(size)
    val bridgeGame = BridgeGame(bridge)
    var index = 0
    var tryCount = 1
    while(true){
        if(index == bridge.size){
            OutputView().printResult(index,bridge,tryCount)
            break
        }
        val userInput = InputView().readMoving()
        val result = bridgeGame.move(index,userInput)
        if (result == "Correct") {
            OutputView().printMap(index,bridge,true)
            index++
        }
        if (result == "Wrong"){
            OutputView().printMap(index,bridge,false)
            val userGameCommand = InputView().readGameCommand()
            if(userGameCommand=="R") {
                tryCount = bridgeGame.retry(tryCount)
                index = 0
            }
            if(userGameCommand=="Q"){
                OutputView().printResult(index,bridge,tryCount)
                break
            }
        }
    }
}
