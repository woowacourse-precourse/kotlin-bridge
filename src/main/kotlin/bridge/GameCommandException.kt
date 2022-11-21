package bridge

class GameCommandException(inputData: String) {
    init {
        isNotRetryOrExitCharacter(inputData)
    }

    private fun isNotRetryOrExitCharacter(inputData: String) {
        TODO("기능구현")
    }
}