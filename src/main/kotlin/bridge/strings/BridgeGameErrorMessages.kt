package bridge.strings

enum class BridgeGameErrorMessages(val message: String) {
    INVALID_REQUEST("[ERROR] 처리할 수 없는 요청입니다"),
    INVALID_REQUEST_NOT_STARTED("[ERROR] 게임 시작 요청을 받지 않은 상태에서 다른 요청을 받았습니다"),
    INVALID_MOVE_REQUEST("[ERROR] 올바른 MOVE 요청이 아닙니다"),
    INVALID_BRIDGE_SIZE("[ERROR] 요한 Bridge size가 정해진 범위를 벗어납니다"),
    INVALID_ACCESS_TO_CHECK("[ERROR] 이미 실패한 BridgeGame에 대해 check 함수를 호출할 수 없지만 호출되었습니다"),
    INVALID_RETRY_REQUEST("[ERROR] 올바른 RETRY 요청이 아닙니다"),
    NUMBER_FORMAT_EXCEPTION("[ERROR] 수로 바꿀 수 없는 문자열의 변환을 시도했습니다"),
    NULL_BRIDGE_RETRY_EXCEPTION("[ERROR] Bridge가 선언되지 않은 상태에서 재시작 여부 요청을 받았습니다"),
    NULL_BRIDGE_CHECKER_MOVE_EXCEPTION("[ERROR] 도로를 초기화하지 않았는데 MOVE 요청을 받았습니다");
}