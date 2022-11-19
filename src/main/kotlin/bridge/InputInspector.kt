package bridge

class InputInspector {

    fun checkBridgeSize(input: String): Boolean {
        if (input.length in 1..2 &&
            input.all { it in '0'..'9' } &&
            input.toInt() in 3..20
        ) {
            return true
        } else {
            throw IllegalArgumentException()
        }
    }

}