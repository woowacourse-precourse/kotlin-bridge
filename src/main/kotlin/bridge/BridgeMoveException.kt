package bridge

class BridgeMoveException(inputData: String) {
    init {
        isNotMoveCharacter(inputData)
    }

    private fun isNotMoveCharacter(inputData: String) {
        if(!(inputData == "U" || inputData == "D"))
            throw IllegalArgumentException("[ERROR] 입력한 값은 'U' 또는 'D'가 아닙니다.")
    }
}