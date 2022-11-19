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

    fun checkMoving(input: String): Boolean {
        if (input == "U" || input == "D") {
            return true
        } else {
            throw IllegalArgumentException()
        }
    }

}