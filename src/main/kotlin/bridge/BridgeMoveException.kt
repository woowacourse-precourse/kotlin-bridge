package bridge

class BridgeMoveException(inputData: String) {
    init {
        isNotMoveCharacter(inputData)
    }

    private fun isNotMoveCharacter(inputData: String) {
        if(!(inputData == "U" || inputData == "D"))
            throw IllegalArgumentException(Message.BRIDGE_MOVE_IS_NOT_U_OR_D)
    }
}