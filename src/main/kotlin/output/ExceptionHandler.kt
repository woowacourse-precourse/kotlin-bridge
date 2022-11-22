package output

object ExceptionHandler {

    fun rangeException(input: Any): Boolean {
        if (input in 3..20) {
            return true
        }
        return false
    }

}