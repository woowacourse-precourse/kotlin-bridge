package bridge
import camp.nextstep.edu.missionutils.Console

object ExceptionCheck {
    fun checkDirection(movingInput : String) {
        require(movingInput == "U" || movingInput == "D"){"[ERROR] 'U' 또는 'D'를 입력해주세요" }
    }

}