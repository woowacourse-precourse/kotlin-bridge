package bridge

var eachBridge = 0
var bridgeSize = ""
var moving = ""
var gameCommand = ""

fun main() {
    getBridgeSize()
    val answerBridge = BridgeMaker(bridgeNumberGenerator = BridgeRandomNumberGenerator()).makeBridge(bridgeSize.toInt())
    while (BridgeGame.bridgeNumber <= bridgeSize.toInt() - 1) { getMoving()
        if (answerBridge[eachBridge] == moving) correctMove()
        else { wrongMove()
            getGameCommand()
            if (gameCommand == "Q") break
            else BridgeGame().retry() } }
    OutputView().printResult()
}

fun getBridgeSize() {
    println("다리 건너기 게임을 시작합니다.\n")
    bridgeSize = InputView().readBridgeSize()
    InputView().checkBridgeSizeException(bridgeSize)
    println()
}

fun getMoving() {
    moving = InputView().readMoving()
    InputView().checkMovingInputException(moving)
}

fun correctMove() {
    BridgeGame().move(moving)
    OutputView().printMap()
    eachBridge += 1
}

fun wrongMove() {
    BridgeGame().moveLose(moving)
    OutputView().printMap()
}

fun getGameCommand() {
    gameCommand = InputView().readGameCommand()
    InputView().checkGameCommandInputException(gameCommand)
}