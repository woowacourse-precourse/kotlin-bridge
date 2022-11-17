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
        if (lengthInput.isEmpty()) {
            println(ERROR_INPUT_BRIDGE_NULL)
            return true
        }
        return false
    }

    private fun typeException(lengthInput: String): Boolean {
        if (!lengthInput.chars().allMatch { Character.isDigit(it) }){
            println(ERROR_INPUT_BRIDGE_TYPE)
            return true
        }
        return false
    }

    private fun rangeException(length: Int): Boolean {
        if (length in MIN_RANGE_LENGTH..MAX_RANGE_LENGTH) return false
        println(ERROR_INPUT_BRIDGE_RANGE)
        return true
    }
}