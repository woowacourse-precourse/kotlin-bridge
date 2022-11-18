package bridge

fun main() {
    onProgramStart()
}

private fun onProgramStart() {
    PrintForm().printGameStartText()
    println(getUserInputBridgeLength())
}

private fun getUserInputBridgeLength() = InputView().readBridgeSize()
