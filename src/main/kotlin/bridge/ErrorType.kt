package bridge

enum class ErrorType(val errorMessage: String) {
    LENGTH(ERROR.format(ERROR_NUMBER_RANGE_MESSAGE))
}