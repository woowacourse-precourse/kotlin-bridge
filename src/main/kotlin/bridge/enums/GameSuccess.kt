package bridge.enums

enum class GameSuccess(private val isSuccess: String) {
    SUCCESS("성공"),
    FAIL("실패");

    fun getGameSuccess() = isSuccess
}