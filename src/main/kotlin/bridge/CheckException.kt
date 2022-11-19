package bridge

class CheckException {


    fun checkInput(size : String){
        when{
            !isNumber(size) -> throw IllegalArgumentException(Strings.INPUT_SIZE_ERROR.phrases)
            size.toInt() < 3 || size.toInt() > 20 -> throw IllegalArgumentException(Strings.INPUT_SIZE_ERROR.phrases)

        }
    }

    fun isNumber(string: String): Boolean {
        return !string.isNullOrEmpty() && string.matches(Regex("\\d+"))
    }

}