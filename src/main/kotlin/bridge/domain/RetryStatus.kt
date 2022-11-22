package bridge.domain

enum class RetryStatus(val retryInput: String) {
    RETRY("R"),
    QUIT("Q")
}