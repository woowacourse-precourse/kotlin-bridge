package bridge

class InputInvalidCheck() {
    fun checkBridgeSize(input: String): Boolean {
        val inputTrim = input.trim()
        if (!checkInputOneInteger(inputTrim)) return false
        return true
    }

    private fun checkInputOneInteger(input: String): Boolean {
        input.forEach { if (!isNumber(it)) return false }
        return true
    }

    private fun isNumber(char: Char): Boolean = char.code in 48..57

    fun checkMoving(input: String): Boolean {
        if (input == "U" || input == "D") return true
        return false
    }
}