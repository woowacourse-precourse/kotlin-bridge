package bridge

class Exception {
    fun bridgesizeRangeException(bridgeSize : String){
        if(bridgeSize.toInt() <3 || bridgeSize.toInt() > 20){
            println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.")
            throw IllegalArgumentException("[ERROR]")
        }
    }
    fun bridgesizeFormatException(bridgeSize: String){
        if (bridgeSize.toIntOrNull() == null) {
            println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.")
            throw IllegalArgumentException("[ERROR]")
        }
    }

    fun movingFormatException(userMove : String){
        if (userMove != "U" && userMove != "D"){
            println("[ERROR] 'U' 혹은 'D' 중 하나의 문자열이여야 합니다.")
            throw IllegalArgumentException("[ERROR]")
        }
    }

    fun commandFormatException(gameControl : String){
        if (gameControl != "Q" && gameControl != "R"){
            println("[ERROR] 'Q' 혹은 'R' 중 하나의 문자열이여야 합니다.")
            throw IllegalArgumentException("[ERROR]")
        }
    }
}