package bridge.domain

import bridge.ERROR_BIG_NUMBER_MESSAGE
import bridge.ERROR_NOT_NUMBER_MESSAGE
import bridge.ERROR_RANGE_BRIDGE_SIZE_MESSAGE

class InputCheck {
    fun checkBridgeSize(bridgeSize: String): Int {
        if (!checkNumber(bridgeSize) || bridgeSize == "")
            throw IllegalArgumentException(ERROR_NOT_NUMBER_MESSAGE)
        if (checkBigNum(bridgeSize) == null)
            throw IllegalArgumentException(ERROR_BIG_NUMBER_MESSAGE)
        if (!checkRangeBridgeSize(bridgeSize))
            throw IllegalArgumentException(ERROR_RANGE_BRIDGE_SIZE_MESSAGE)
        return bridgeSize.toInt()
    }

    private fun checkNumber(bridgeSize: String): Boolean =
        bridgeSize.count() == bridgeSize.replace("\\D".toRegex(), "").count()

    private fun checkBigNum(bridgeSize: String) = bridgeSize.toIntOrNull()

    private fun checkRangeBridgeSize(bridgeSize: String): Boolean {
        if (bridgeSize.toInt() < 3 || bridgeSize.toInt() > 20)
            return false
        return true
    }
}
