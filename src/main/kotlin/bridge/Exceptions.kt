package bridge

class Exceptions {
    private val outputView = OutputView()
    fun validateBridgeSize(x: String) {
        val size = x.toIntOrNull()
        require (size != null) {
            outputView.printSizeInputError()
            throw IllegalArgumentException()
        }
        require (size in (SIZE_RANGE_START..SIZE_RANGE_END)) {
            OutputView().printSizeRangeError()
            throw IllegalArgumentException()
        }
    }

    fun validateMoving(x: String) {
        require(x in UP_DOWN) {
            outputView.printMovingInputError()
            throw IllegalArgumentException()
        }
    }

    fun validateCommand(x: String?) {
        require(x in RESTART_QUIT) {
            outputView.printCommandInputError()
            throw IllegalArgumentException()
        }
    }

    companion object {
        const val SIZE_RANGE_START = 3
        const val SIZE_RANGE_END = 20
        val UP_DOWN = listOf("U", "D")
        val RESTART_QUIT = listOf("R", "Q")
    }
}