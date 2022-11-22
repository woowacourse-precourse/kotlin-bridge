package bridge.common

enum class GameState(val result: String) {
    IN_GAME(""),
    SUCCESS("게임 성공 여부: 성공"),
    FAILURE("게임 성공 여부: 실패");
}
