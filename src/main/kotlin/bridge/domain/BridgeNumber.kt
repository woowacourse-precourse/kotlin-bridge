package bridge.domain

import bridge.BRIDGE
import bridge.ERROR
import bridge.utils.ErrorType
import bridge.utils.MAX_LENGTH
import bridge.utils.MIN_LENGTH
import bridge.utils.ZERO

class BridgeNumber(private val size: String) {
    init {
        require(isEmtpy()) { ERROR.format(ErrorType.EMPTY.errorMessage) }
        require(isNumber()) { ERROR.format(BRIDGE + ErrorType.NUMBER.errorMessage) }
        require(isNumberRange()) { ERROR.format(BRIDGE + ErrorType.RANGE.errorMessage) }
    }

    private fun isNumberRange(): Boolean =
        size.toInt() in MIN_LENGTH..MAX_LENGTH

    private fun isNumber(): Boolean =
        size.all { char -> char.isDigit() }

    private fun isEmtpy(): Boolean =
        size.isNotEmpty() || size.length > ZERO
}