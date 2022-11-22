package bridge.validator

class MovingValidator : Validator() {
    override fun checkInput(input: String) {
        if (!checkMovingIsUorD(input)) {
            require(false)
        }
    }

    private fun checkMovingIsUorD(input: String): Boolean {
        return input == "D" || input == "U"
    }
}