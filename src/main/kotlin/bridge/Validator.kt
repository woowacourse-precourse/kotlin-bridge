package bridge

import kotlin.IllegalArgumentException as IllegalArgumentException1

class Validator {
    fun validateBridgeSize(bridgeSize: String?): Int {
        try{ validatorNumeric(bridgeSize)
        }catch (e: IllegalArgumentException){
            println(ERROR_BRIDGE_SIZE_STRING)
            return InputView().readBridgeSize() }

        val bridgeLength= bridgeSize!!.toInt()
        try{ validatorRange(bridgeLength)
        }catch (e: IllegalArgumentException){
            println(ERROR_BRIDGE_SIZE)
            return InputView().readBridgeSize() }
        return bridgeLength
    }

    fun validatorMove(move: String?): String {
        val moving = move.toString()
        try{
            validatorUpDown(moving)
        }catch (e: IllegalArgumentException){
            println(ERROR_MOVING)
            return InputView().readMoving()
        }
        return moving
    }

    fun validatorGameCommand(command: String?): String {
        val gameCommand = command.toString()
        try{
            validatorResetQuit(gameCommand)
        }catch (e: IllegalArgumentException){
            println(ERROR_GAME_COMMAND)
            return InputView().readGameCommand()
        }
        return gameCommand
    }

    private fun validatorNumeric(input: String?): Int {
        try{
            return input!!.toInt()
        }catch (e: IllegalArgumentException){
            throw e
        }
    }

    private fun validatorRange(input: Int): Boolean {
        if(input in 3..20){
            return true
        }
        throw IllegalArgumentException()
    }

    private fun validatorUpDown(input: String): Boolean {
        if(input == "U" || input == "D"){
            return true
        }
        throw IllegalArgumentException()
    }

    private fun validatorResetQuit(input: String): Boolean {
        if(input == "R" || input == "Q"){
            return true
        }
        throw IllegalArgumentException()
    }
}