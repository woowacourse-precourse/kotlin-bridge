package bridge

class GameCommandException(inputData: String) {
    init {
        isNotRetryOrExitCharacter(inputData)
    }

    private fun isNotRetryOrExitCharacter(inputData: String) {
        if(!(inputData == "R" || inputData == "Q"))
            throw IllegalArgumentException("[ERROR] 입력한 값은 'R' 또는 'Q'가 아닙니다.")
    }
}