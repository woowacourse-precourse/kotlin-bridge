package values

enum class Inform(val message: String) {
    GAME_START("다리 건너기 게임을 시작합니다."),
    RESULT("최종 게임 결과"),
    SUCCESS_OR_FAILURE("게임 성공 여부"),
    TRY_NUMBER("총 시도한 횟수")
}