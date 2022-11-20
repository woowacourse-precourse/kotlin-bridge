package bridge

import Utils.Constants.TYPE_BRIDGE_SIZE
import Utils.Constants.TYPE_COMMAND
import Utils.Constants.TYPE_MOVING

// 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고,
// "[ERROR]"로 시작하는 에러 메시지를 출력 후 **그 부분부터 입력을 다시 받는다.**
// ERROR를 상수 말고 enum으로 처리 해볼까? 이건 저번주 피드백 보고 결정해보자. enum을 사용하는 이유 적혀있었음
class Rule {

    fun checkValue(input: String, type: String) {
        when(type) {
            TYPE_BRIDGE_SIZE -> checkBridgeSize(input)
            TYPE_MOVING -> checkMoving(input)
            TYPE_COMMAND -> checkCommand(input)
        }
    }
    // todo Error 메세지 상수 처리 or enum 처리
    private fun checkBridgeSize(input: String) {
        val bridgeSize = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 문자 주어짐")

        if(bridgeSize < RANGE_LOWER_INCLUSIVE || bridgeSize > RANGE_UPPER_INCLUSIVE)
            throw IllegalArgumentException("[ERROR] 3-20 범위 벗어남")
    }
    private fun checkMoving(moving: String) {
        if(moving != "U" && moving != "D") throw IllegalArgumentException("[ERROR] U 또는 D가 아님")
    }
    private fun checkCommand(command: String) {
        if(command != "R" && command != "Q") throw IllegalArgumentException("[ERROR] R 또는 Q가 아님")
    }

    // 이거 Constants에 옮기기?
    companion object {
        const val RANGE_LOWER_INCLUSIVE = 3
        const val RANGE_UPPER_INCLUSIVE = 20
    }
}