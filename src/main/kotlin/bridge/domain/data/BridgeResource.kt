package bridge.domain.data

enum class BridgeKeyword(val keyword: String) {
    PASS("O"),
    FAIL("X"),
    UP("U"),
    DOWN("D"),
    BLANK(" "),
    RETRY("R"),
    QUIT("Q")
}

enum class BridgeNumber(val number: Int) {
    ONE(1),
    ZERO(0),
    MAX_BRIDGE_SIZE(20),
    MIN_BRIDGE_SIZE(3)
}

enum class BridgeOutputText(val text: String) {
    SUCCESS_TEXT("게임 성공 여부: 성공"),
    FAIL_TEXT("게임 성공 여부: 실패"),
    TOTAL_CHALLENGE("총 시도한 횟수: "),
    FINAL_RESULT("최종 게임 결과"),
    RETRY_TEXT("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    CHOOSE_ROWS("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    BRIDGE_SIZE("다리의 길이를 입력해주세요.")
}