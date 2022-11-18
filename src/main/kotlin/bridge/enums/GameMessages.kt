package bridge.enums

enum class GameMessages(private val messages: String) {
    START("다리 건너기 게임을 시작합니다."),
    INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    INPUT_UP_DOWN("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    INPUT_RESTART_QUIT("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    RESULT("최종 게임 결과"),
    IS_CLEAR("게임 성공 여부:"),
    TRY_COUNT("총 시도한 횟수:");

    override fun toString(): String = messages
}