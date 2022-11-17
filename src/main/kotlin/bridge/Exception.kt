package bridge

import bridge.Constant.INPUT_RANGE_ERROR_MESSAGE
import bridge.Constant.INPUT_TYPE_ERROR_MESSAGE

fun String.bridgeSizeInputTypeException(): Int {
    return try {
        if (this.toInt() < 3 || this.toInt() > 20)  throw IllegalArgumentException(INPUT_RANGE_ERROR_MESSAGE)
        else this.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException(INPUT_TYPE_ERROR_MESSAGE)
    }
}