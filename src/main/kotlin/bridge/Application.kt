package bridge

var answerBridge: List<String> = listOf()

fun main() {
    OutputView().printGameStart()

    val bridgeLength = InputView().readBridgeSize()
    val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
    answerBridge = bridgeMaker.makeBridge(bridgeLength)

    var trial = 1
    doGame(trial)
}

fun doGame(trial: Int) {
    var inputBridge = listOf<String>()
    var success = true
    while (success && (inputBridge != answerBridge)) {
        var whereToMove = InputView().readMoving()
        inputBridge = BridgeGame(answerBridge).move(whereToMove, inputBridge)
        success = BridgeGame(answerBridge).checkSuccess(inputBridge)
        OutputView().printMap(inputBridge)
    }
    printResultWhenAllAnswer(inputBridge, trial)
    restartGameWhenFail(success, inputBridge, trial)
}

private fun printResultWhenAllAnswer(inputBridge: List<String>, trial: Int) {
    if (inputBridge == answerBridge) OutputView().printResult(inputBridge, true, trial)
}

private fun restartGameWhenFail(success: Boolean, inputBridge: List<String>, trial: Int) {
    if (!success) restartGame(inputBridge, trial)
}

private fun restartGame(inputBridge: List<String>, trial: Int) {
    var inputRestartGame = InputView().readGameCommand()
    when (inputRestartGame) {
        "R" -> BridgeGame(answerBridge).retry(trial)
        "Q" -> OutputView().printResult(inputBridge, false, trial)
    }
}