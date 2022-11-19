package bridge

enum class Result(private val resultMessage: String) {
    SUCCESS("성공"), FAIL("실패");

    fun getResultMessage() : String = resultMessage
}