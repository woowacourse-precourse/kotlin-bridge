package bridge.exception

import bridge.Strings

class CheckException {

    fun checkInputSize(size : String){
        when{
            !isNumber(size) -> throw IllegalArgumentException(Strings.ERROR_INPUT_SIZE.phrases)
            size.toInt() < 3 || size.toInt() > 20 -> throw IllegalArgumentException(Strings.ERROR_INPUT_SIZE.phrases)

        }
    }

    fun checkInputDirection(move : String){
        if (move != "U" && move != "D"){
            throw IllegalArgumentException(Strings.ERROR_INPUT_DIRECTION.phrases)
        }
    }

    fun checkInputRestart(restart : String){
        if (restart != "R" && restart != "Q"){
            throw IllegalArgumentException(Strings.ERROR_INPUT_RESTART.phrases)
        }
    }

    fun isNumber(string: String): Boolean {
        return !string.isNullOrEmpty() && string.matches(Regex("\\d+"))
    }

}