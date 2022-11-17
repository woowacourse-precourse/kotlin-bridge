package bridge

enum class ErrorType(val errorMessage: String) {
    LENGTH(ERROR.format(ERROR_NUMBER_RANGE_MESSAGE)),
    NUMBER(ERROR.format(ERROR_NUMBER_MESSAGE)),
    EMPTY(ERROR.format(ERROR_EMPTY_MESSAGE))
}