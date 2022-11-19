package bridge.ui.validator

import bridge.ui.common.ERROR_BRIDGE_SIZE_MESSAGE
import bridge.ui.common.MAX_BRIDGE_SIZE
import bridge.ui.common.MIN_BRIDGE_SIZE

object InputValidator {
    fun validateBridgeSize(bridgeSize: String) {
        (bridgeSize.isDigit() && bridgeSize.isCorrectSize()).let { isCorrectBridgeSize ->
            if (!isCorrectBridgeSize) throw IllegalArgumentException(ERROR_BRIDGE_SIZE_MESSAGE)
        }
    }

    private fun String.isDigit(): Boolean =
        this.all { eachChar -> eachChar.isDigit() }

    private fun String.isCorrectSize(): Boolean =
        this.toInt() in MIN_BRIDGE_SIZE .. MAX_BRIDGE_SIZE

}