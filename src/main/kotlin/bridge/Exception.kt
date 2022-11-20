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

// 당연히 둘 중 하나가 아니라면 !! 오류지 바보 아님?
// UP, DOWN인 것만 통과하도록 만들기
fun checkValidMoveInput(input : String){
    when(input){
        UP -> return
        DOWN -> return
        else -> throw IllegalArgumentException()
    }

}

fun checkValidRestartInput(input : String){
    when(input){
        RETRY -> return
        QUIT -> return
        else -> throw IllegalArgumentException()
    }
}