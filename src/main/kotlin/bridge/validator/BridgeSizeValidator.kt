package bridge.validator

class BridgeSizeValidator : Validator() {
    override fun checkInput(input: String) {
        if (!checkBridgeSizeScopeException(input) || !checkBridgeSizeIsNumeric(input)) {
            require(false)
        }
    }

    private fun checkBridgeSizeScopeException(input: String): Boolean {
        return input.toInt() in 3..20
    }

    private fun checkBridgeSizeIsNumeric(input: String): Boolean {
        return input.all { char -> char.isDigit() }
    }
}