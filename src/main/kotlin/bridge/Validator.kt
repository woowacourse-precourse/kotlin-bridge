package bridge

class Validator {
    fun validateBridgeSize(bridgeSize: String) {
        val bridgeLength = validatorNumeric(bridgeSize)
        validatorRange(bridgeLength)
    }

    fun validatorMove(move: String?): Boolean {
        if(move == "U" || move == "D"){
            return true
        }
        throw IllegalArgumentException(ERROR_MOVING)
    }

    fun validatorGameCommand(command: String): Boolean {
        if(command == "R" || command == "Q"){
            return true
        }
        throw IllegalArgumentException(ERROR_GAME_COMMAND)
    }

    private fun validatorNumeric(input: String): Int {
        try{
            return input.toInt()
        }catch (e: NumberFormatException){
            throw IllegalArgumentException(ERROR_BRIDGE_SIZE_STRING)
        }
    }

    private fun validatorRange(input: Int): Boolean {
        if(input in 3..20){
            return true
        }
        throw IllegalArgumentException(ERROR_BRIDGE_SIZE)
    }

}