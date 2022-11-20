package bridge.utils

class ExceptionChecker {
    fun bridgeSizeIsDigitException(size: String){
        require(size.all { it.isDigit() }){ println(ERROR_PREFIX + "다리 길이는 3부터 20 사이의 숫자여야 합니다.") }
    }

    fun bridgeSizeIsInRangeException(size: Int){
        require(size in 3 .. 20){ println(ERROR_PREFIX + "다리 길이는 3부터 20 사이의 숫자여야 합니다.") }
    }

    companion object {
        const val ERROR_PREFIX = "[ERROR] "
    }
}