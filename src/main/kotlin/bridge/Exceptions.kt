package bridge

class Exceptions {
    fun validateBridgeSize(x: String) {
        val size = x.toIntOrNull()
        require (size != null) {
            OutputView.printSizeInputError()
            throw IllegalArgumentException()
        }
        require (size in (SIZE_RANGE_START..SIZE_RANGE_END)) {
            OutputView.printSizeRangeError()
            throw IllegalArgumentException()
        }
    }

    fun validateMoving(x: String) {
        require(x in listOf("U", "D")) {
            OutputView.printMovingInputError()
            throw IllegalArgumentException()
        }
    }

    fun validateCommand(x: String?) {
        require(x in listOf("R", "Q")) {
            OutputView.printCommandInputError()
            throw IllegalArgumentException()
        }
    }

    companion object {
        const val SIZE_RANGE_START = 3
        const val SIZE_RANGE_END = 20
    }
}