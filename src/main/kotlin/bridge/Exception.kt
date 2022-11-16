package bridge.view
import bridge.resources.*
import kotlin.IllegalArgumentException

object BridgeLengthException {
    fun exceptions(input: String) {
        if (nullException(input)) throw IllegalArgumentException(ERROR_INPUT_BRIDGE_TYPE)
        if (typeException(input)) throw IllegalArgumentException(ERROR_INPUT_BRIDGE_TYPE)
        if (rangeException(input.toInt())) throw IllegalArgumentException(ERROR_INPUT_BRIDGE_RANGE)
    }

    private fun nullException(input: String): Boolean {
        return input.isEmpty()
    }

    private fun typeException(input: String): Boolean {
        return !input.chars().allMatch { Character.isDigit(it) }
    }

    private fun rangeException(length: Int): Boolean {
        if (length in MIN_RANGE_LENGTH..MAX_RANGE_LENGTH) return false
        return true
    }
}