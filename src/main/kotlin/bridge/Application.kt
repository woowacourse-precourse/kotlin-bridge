package bridge

fun main() {
    onProgramStart()
}

private fun onProgramStart() {
    PrintForm().printGameStartText()
    onStartGame()
}

private fun onStartGame() {
    val userInputBridgeLength = getUserInputBridgeLength()
    val bridge = makeBridge(userInputBridgeLength)
    playBridgeGame(bridge)
}

private fun getUserInputBridgeLength() = InputView().readBridgeSize()

private fun makeBridge(userInputNumber : Int) : List<String> = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(userInputNumber)

private fun playBridgeGame(bridge : List<String>) {
    BridgeGame(bridge).move()
}
