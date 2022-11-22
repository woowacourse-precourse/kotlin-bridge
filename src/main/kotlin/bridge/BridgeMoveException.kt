package bridge

class BridgeMoveException(inputData: String) {
    companion object {
        const val BRIDGE_MOVE_IS_NOT_U_OR_D = "[ERROR] 입력한 값은 'U' 또는 'D'가 아닙니다."
    }

    init {
        isNotMoveCharacter(inputData)
    }

    private fun isNotMoveCharacter(inputData: String) {
        if(!(inputData == "U" || inputData == "D"))
            throw IllegalArgumentException(BRIDGE_MOVE_IS_NOT_U_OR_D)
    }
}