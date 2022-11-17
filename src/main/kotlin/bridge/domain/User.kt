package bridge.domain

import bridge.view.InputView

class User {
    fun inputBridgeSize() = InputView().readBridgeSize()

    fun inputMoving() = InputView().readMoving()
}
