package bridge

import bridge.domain.InputCheck

fun main() {
    val checkInput = InputCheck()
    val showInputView = InputView()
    val bridgeSize = checkInput.checkBridgeSize(showInputView.readBridgeSize())
}
