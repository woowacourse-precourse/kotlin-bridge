package bridge

import bridge.data.ErrorMessage.ERROR_NOT_NUMBERS
import bridge.data.ErrorMessage.ERROR_NOT_UP_DOWN
import bridge.data.ErrorMessage.ERROR_NUM_NOT_IN_RANGE

class Number

fun String.inputTypeException():Int{
    try{
        return this.toInt()
    }catch(e:NumberFormatException) {
        throw IllegalArgumentException(ERROR_NOT_NUMBERS)
    }
}

fun Int.inputRangeException(){
    require(this in 3..20) { ERROR_NUM_NOT_IN_RANGE }
}

fun String.inputUpDownException(){
    require(this in listOf("U","D")){ERROR_NOT_UP_DOWN}
}