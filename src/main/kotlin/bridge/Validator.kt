package bridge

class Validator {
    fun validateBridgeSize(bridgeSize: String?): Int {
        require(validatorNumeric(bridgeSize)){
            println(ERROR_BRIDGE_SIZE_STRING)
            InputView().readBridgeSize()
        }
        val bridgeLength= bridgeSize!!.toInt()
        require(bridgeLength in 3..20){
            println(ERROR_BRIDGE_SIZE)
            InputView().readBridgeSize()
        }
        return bridgeLength
    }

    private fun validatorNumeric(input: String?): Boolean {
        return try{
            input!!.toInt()
            true
        }catch (e: IllegalArgumentException){
            false
        }
    }
}