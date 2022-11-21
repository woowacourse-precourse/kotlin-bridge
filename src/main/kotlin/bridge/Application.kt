package bridge

fun checkUserInput(index: Int, bridgeGame: BridgeGame,outputView: OutputView): Boolean {
    val userInput = InputView().readMoving()
    val result =  bridgeGame.move(index, userInput)
    return if(result == "Correct") {
        outputView.printMap(index, true)
        true
    } else {
        outputView.printMap(index,false)
        false
    }
}
fun checkUserGameCommand(bridge: List<String>,tryCount: Int,idx:Int): Int {
    val userGameCommand = InputView().readGameCommand()
    return if (userGameCommand== "R")
        playGame(bridge, tryCount+1)
    else {
        OutputView(bridge).printResult(idx, tryCount)
        0
    }
}

fun playGame(bridge:List<String>,tryCount:Int): Int {
    for(idx in bridge.indices) {
        if (!checkUserInput(idx, BridgeGame(bridge), OutputView(bridge))) {
            return checkUserGameCommand(bridge,tryCount,idx)
        }
    }
    return tryCount
}
fun main() {
    println("다리 건너기 게임을 시작합니다.")
    val size = InputView().readBridgeSize()
    val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(size)
    val finalTryCount = playGame(bridge,1)
    if (finalTryCount!=0)
        OutputView(bridge).printResult(bridge.size,finalTryCount)
}