package bridge

class Exceptions {
    fun validateBridgeSize(x: String) {
        val size = x.toIntOrNull()
        require (size != null) {
            OutputView.printInputError()
            throw IllegalArgumentException()
        }
        require (size in SIZE_RANGE_START..SIZE_RANGE_END) {
            OutputView.printSizeError()
            throw IllegalArgumentException()
        }
    }

    companion object {
        const val SIZE_RANGE_START = 3
        const val SIZE_RANGE_END = 20
    }
}