package bridge

class GameCommandException(inputData: String) {
    companion object {
        const val GAME_COMMAND_IS_NOT_R_OR_Q = "[ERROR] 입력한 값은 'R' 또는 'Q'가 아닙니다."
    }

    init {
        isNotRetryOrExitCharacter(inputData)
    }

    private fun isNotRetryOrExitCharacter(inputData: String) {
        if(!(inputData == "R" || inputData == "Q"))
            throw IllegalArgumentException(GAME_COMMAND_IS_NOT_R_OR_Q)
    }
}