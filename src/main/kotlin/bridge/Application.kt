package bridge

var i = 0

fun main() {
    println("다리 건너기 게임을 시작합니다.\n")

    val bridgeSize = InputView().readBridgeSize()
    InputView().checkBridgeSizeException(bridgeSize)
    println()

    val answerBridge = BridgeMaker(bridgeNumberGenerator = BridgeRandomNumberGenerator()).makeBridge(bridgeSize.toInt())

    while (BridgeGame.bridgeNumber <= bridgeSize.toInt()-1) {
        val moving = InputView().readMoving()
        InputView().checkMovingInputException(moving)

        if (answerBridge[i] == moving) {
            BridgeGame().move(moving)
            OutputView().printMap()
            i += 1
        }
        else {
            BridgeGame().moveLose(moving)
            OutputView().printMap()
            val gameCommand = InputView().readGameCommand()
            InputView().checkGameCommandInputException(gameCommand)
            if (gameCommand == "Q") break
            else BridgeGame().retry()
        }
    }

    BridgeGame().checkWinLose()
    OutputView().printResult()

}
