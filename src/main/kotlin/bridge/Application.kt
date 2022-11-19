package bridge

fun startGame(): List<String> {
    val bridge: List<String>
    val size: Int
    size = InputView().readBridgeSize()
    println("")
    bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(size)
    return bridge
}

fun proceedGame(bridge: List<String>): MutableList<String> {
    var moving: String
    val movingResult = mutableListOf<String>()
    for (route in bridge) {
        moving = InputView().readMoving()
        movingResult.add(BridgeGame().move(route, moving))
        OutputView().printMap(bridge, movingResult)
        if (movingResult.contains("X")) break // == if loss >>> break
    }
    return movingResult
}

fun finishGame(bridge: List<String>, movingResult: List<String>, tryCount: Int) {
    var gameCommand = "R"
    if (movingResult.contains("X")) {
        gameCommand = InputView().readGameCommand()
        if (gameCommand == "R") BridgeGame().retry(bridge, tryCount+1)
        if (gameCommand == "Q") OutputView().printResult(bridge, movingResult, gameCommand, tryCount)
    }
    else OutputView().printResult(bridge, movingResult, gameCommand, tryCount)
}

fun main() {
    val bridge: List<String>
    val movingResult: MutableList<String>
    println("다리 건너기 게임을 시작합니다.\n")
    bridge = startGame()
    movingResult = proceedGame(bridge)
    finishGame(bridge, movingResult,1)
}