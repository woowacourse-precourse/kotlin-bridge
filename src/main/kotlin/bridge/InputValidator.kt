package bridge

class InputValidator {
    companion object{

        fun checkOnlyNumber(input: String){
            val regexOnlyNumber = Regex("-?\\d+(\\.\\d+)?")
            if (!regexOnlyNumber.matches(input)) {
                throw IllegalArgumentException(Constants.ERROR_NOT_ONLY_NUMBER)
            }
        }

        fun checkInBridgeRange(input: String){
            if(input.toInt() < 3 || input.toInt()> 24){
                throw IllegalArgumentException(Constants.ERROR_OUT_OF_RANGE_BRIDGE)
            }
        }

        fun checkOnlyCharacter(input: String){
            val regexOnlyAlphaBet = Regex("^[a-zA-Z]*\$")
            if(!regexOnlyAlphaBet.matches(input)){
                throw IllegalArgumentException(Constants.ERROR_NOT_ONLY_CHARACTER)
            }
        }

        fun checkUorD(input: String){
            if(input!="U" && input!="D"){
                throw IllegalArgumentException(Constants.ERROR_OUT_OF_RANGE_MOVE)
            }
        }
    }
}