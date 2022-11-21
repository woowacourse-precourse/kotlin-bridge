package bridge

enum class BridgeGameStatus(val message: String) {
    SUCCESS("성공"),
    CONTINUE("계속"),
    FAILURE("실패");
}