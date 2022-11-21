package bridge
import camp.nextstep.edu.missionutils.Console

object ExceptionCheck {
    fun checkDirection(movingInput : String) {
        require(movingInput == "U" || movingInput == "D"){"[ERROR] 'U' 또는 'D'를 입력해주세요" }
    }
    fun checkBridgeSize(bridgeSize :String){
        require(bridgeSize.all{it.isDigit()}){"[ERROR] : 숫자만 입력해야 합니다."}
        require(bridgeSize.toInt() in 3..20){"[ERROR] : 3부터 20까지의 숫자를 입력해야 합니다."}
    }

}