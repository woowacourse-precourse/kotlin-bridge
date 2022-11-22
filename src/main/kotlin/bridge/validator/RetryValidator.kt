package bridge.validator

class RetryValidator() : Validator() {
    override fun checkInput(input: String) {
        if (!checkCommendIsRorQ(input)) {
            require(false)
        }
    }

    private fun checkCommendIsRorQ(input: String): Boolean {
        return input == "R" || input == "Q"
    }
}