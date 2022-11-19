package bridge

// 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고,
// "[ERROR]"로 시작하는 에러 메시지를 출력 후 **그 부분부터 입력을 다시 받는다.**
// ERROR를 상수 말고 enum으로 처리 해볼까? 이건 저번주 피드백 보고 결정해보자. enum을 사용하는 이유 적혀있었음
class Rule {

    // 자동으로 생성할 다리 길이를 입력 받는다.
    // 3 이상 20 이하의 '숫자'를 입력할 수 있으며 올바른 값이 아니면 예외 처리한다.
    
    // todo Error 메세지 상수 처리 or enum 처리
    fun checkBridgeSize(input: String): Int {
        val bridgeSize = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 문자 주어짐")

        if(bridgeSize < RANGE_LOWER_INCLUSIVE || bridgeSize > RANGE_UPPER_INCLUSIVE)
            throw IllegalArgumentException("[ERROR] 3-20 범위 벗어남")

        return bridgeSize
    }

    fun checkMoving(moving: String) {

    }

    fun checkCommand(command: String) {

    }

    // 이거 Constants에 옮기기?
    companion object {
        const val RANGE_LOWER_INCLUSIVE = 3
        const val RANGE_UPPER_INCLUSIVE = 20
    }
}