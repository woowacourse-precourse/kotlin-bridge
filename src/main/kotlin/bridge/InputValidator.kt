package bridge

object InputValidator {

    fun validateBridgeSize(bridgeSize: Int) =
        require(bridgeSize in 3..20) {
            println(Error.BRIDGE_RANGE_ERROR)
        }

    fun validateNumericInput(input : String){
        require(input.isNumeric()){
            println(Error.NUMERIC_ERROR)
        }
    }


    private fun String.isNumeric() =
        this.chars().allMatch { eachChar -> Character.isDigit(eachChar) }

}