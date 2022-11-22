package bridge.enums

enum class Status(private val status: String) {
    CORRECT("correct"),
    WRONG("wrong");

    override fun toString(): String = status
}