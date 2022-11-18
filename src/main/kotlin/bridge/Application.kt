package bridge

fun main() {
    onProgramStart()
}

private fun onProgramStart() {
    PrintForm().printGameStartText()
    getUserInputBridgeLength()
}

private fun getUserInputBridgeLength() = InputView().readBridgeSize()
