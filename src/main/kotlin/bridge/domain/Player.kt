package bridge.domain

data class Player(
    var isGameOver: Boolean = true,
    var isGameSuccess: Boolean = true,
    var retryCount: Int = 1
) {
    fun setGameFailure() {
        isGameSuccess = false
    }

    fun setGameRetry() {
        isGameOver = true
    }

    fun setRetryCount() {
        retryCount += 1
    }

    fun setGameQuit() {
        isGameOver = false
    }
}