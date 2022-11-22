package util

enum class Game (val message: String) {
    START_GAME("다리 건너기 게임을 시작합니다."),
    BRIDGE_LENGTH_INPUT("다리의 길이를 입력해주세요."),
    MOVE_INPUT("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    RETRY_INPUT("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)\n"),
    RESULT("최종 게임 결과"),
    SUCCESS_OR_NOT("게임 성공 여부: "),
    TOTAL_ATTEMPTS("총 시도한 횟수: "),
    SUCCESS("성공"),
    FAIL("실패")
}