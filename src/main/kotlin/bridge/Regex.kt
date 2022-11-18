package bridge

object Regex {

    fun checkItsNull(userInput: String) {
        if(userInput.isEmpty()) {
            throw IllegalArgumentException()
        }
    }

}