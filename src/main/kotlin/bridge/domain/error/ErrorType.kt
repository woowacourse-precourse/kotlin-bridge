package bridge.domain.error

import bridge.domain.resource.*

enum class ErrorType(private val message: String) {
    NOT_INTEGER(ERROR_FORMAT.format(ERROR_NOT_INTEGER)),
    OUT_OF_RANGE(ERROR_FORMAT.format(ERROR_RANGE)),
    INVALID_OPTION(ERROR_FORMAT.format(ERROR_OPTION));

    companion object {
        fun makeError(error: ErrorType) {
            throw IllegalArgumentException(error.message)
        }
    }
}