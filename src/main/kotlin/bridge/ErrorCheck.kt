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

    fun checkReadMoving(moving: String){
        if(moving != "U" || moving != "D"){
            println("[ERROR] 움직임은 U 또는 D만 입력할 수 있습니다.")
            throw IllegalArgumentException()
        }
    }

    fun checkCommand(command: String){
        if(command != "R" || command != "Q"){
            println("[ERROR] 재시작 여부를 결정할 때는 R 또는 Q를 입력해야 합니다.")
            throw IllegalArgumentException()
        }
    }

}