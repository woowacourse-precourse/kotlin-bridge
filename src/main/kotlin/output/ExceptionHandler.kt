package output

object ExceptionHandler {

    fun rangeException(input: Any): Boolean {
        if (input in 3..20) {
            return true
        }
        return false
    }

    fun specificAlphabetUD(input: String): Boolean {
        if (input == "U" || input == "D") {
            return true
        }
        return false
    }
}