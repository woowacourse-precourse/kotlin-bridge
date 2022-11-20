package bridge.domain

import bridge.utils.ONE

data class Player(
    var isGameOver: Boolean = true,
    var isGameSuccess: Boolean = true,
    var retryCount: Int = ONE
) {
    fun setGameFailure() {
        isGameSuccess = false
    }

    fun setGameRetry() {
        isGameOver = true
    }

    fun setRetryCount() {
        retryCount += ONE
    }

    fun setGameQuit() {
        isGameOver = false
    }
}