package bridge

import java.util.regex.Pattern

fun checkInputIsDigit(input : String){
    if(!Pattern.matches("^[0-9]*", input)){
        throw IllegalArgumentException()
    }
}

fun checkValidBridgeSize(bridgeSize : Int){
    if(bridgeSize < MIN_SIZE || bridgeSize > MAX_SIZE){
        throw IllegalArgumentException()
    }
}

fun checkValidMoveInput(input : String){
    if(input != UP || input != DOWN){
        println(input)
        throw IllegalArgumentException()
    }
}

fun checkValidRestartInput(input : String){
    if(input != RETRY || input != QUIT){
        throw IllegalArgumentException()
    }
}