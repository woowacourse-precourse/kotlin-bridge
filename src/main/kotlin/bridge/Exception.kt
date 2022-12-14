package bridge

import bridge.Constant.DOWN
import bridge.Constant.INPUT_RANGE_ERROR_MESSAGE
import bridge.Constant.INPUT_TYPE_ERROR_MESSAGE
import bridge.Constant.QUIT
import bridge.Constant.REPLAY
import bridge.Constant.UP

fun String.bridgeSizeInputTypeException(): Int {
    return try {
        if (this.toInt() in 3.. 20) this.toInt()
        else throw IllegalArgumentException(INPUT_RANGE_ERROR_MESSAGE)
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException(INPUT_TYPE_ERROR_MESSAGE)
    }
}

fun String.movingInputTypeException(): String = if (this == UP || this == DOWN) this else throw IllegalArgumentException(INPUT_TYPE_ERROR_MESSAGE)

fun String.gameCommandInputTypeException(): String = if (this == REPLAY || this == QUIT) this else throw IllegalArgumentException(INPUT_TYPE_ERROR_MESSAGE)