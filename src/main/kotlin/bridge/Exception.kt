package bridge

import java.util.regex.Pattern

fun checkInputIsDigit(input : String){
    if(!Pattern.matches("^[0-9]*", input)){
        throw IllegalArgumentException()
    }
}

fun checkValidBridgeSize(bridgeSize : Int){
    if(bridgeSize < 3 || bridgeSize > 20){
        throw IllegalArgumentException()
    }
}

fun checkValidMoveInput(input : String){
    if(input != "U" || input != "D"){
        throw IllegalArgumentException()
    }
}

fun checkValidRestartInput(input : String){
    if(input != "R" || input != "Q"){
        throw IllegalArgumentException()
    }
}