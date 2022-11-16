package bridge.Exception
import bridge.resources.*
import kotlin.IllegalArgumentException

object BridgeLengthException {
    fun exceptions(lengthInput: String) {
        if (nullException(lengthInput)) throw IllegalArgumentException(ERROR_INPUT_BRIDGE_NULL)
        if (typeException(lengthInput)) throw IllegalArgumentException(ERROR_INPUT_BRIDGE_TYPE)
        if (rangeException(lengthInput.toInt())) throw IllegalArgumentException(ERROR_INPUT_BRIDGE_RANGE)
    }

    private fun nullException(lengthInput: String): Boolean {
        return lengthInput.isEmpty()
    }

    private fun typeException(lengthInput: String): Boolean {
        return !lengthInput.chars().allMatch { Character.isDigit(it) }
    }

    private fun rangeException(length: Int): Boolean {
        if (length in MIN_RANGE_LENGTH..MAX_RANGE_LENGTH) return false
        return true
    }
}