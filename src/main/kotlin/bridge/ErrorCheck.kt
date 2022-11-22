package bridge

class ErrorCheck {
    fun checkBridgeSize(bridgeSize: String){
        if(bridgeSize.toIntOrNull() == null) {
            println("[ERROR] 다리 길이는 숫자를 입력해주세요.")
            throw IllegalArgumentException()
        }
    }

    fun checkBridgeRange(bridgeSize: Int){
        if(bridgeSize < 3 || bridgeSize > 20){
            println("[ERROR] 다리 길이는 3 ~ 20 범위 내여야 합니다.")
            throw IllegalArgumentException()
        }
    }


}