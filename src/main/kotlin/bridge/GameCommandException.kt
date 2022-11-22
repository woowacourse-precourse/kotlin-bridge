package bridge

class GameCommandException(inputData: String) {
    init {
        isNotRetryOrExitCharacter(inputData)
    }

    private fun isNotRetryOrExitCharacter(inputData: String) {
        if(!(inputData == "R" || inputData == "Q"))
            throw IllegalArgumentException(Message.GAME_COMMAND_IS_NOT_R_OR_Q)
    }
}