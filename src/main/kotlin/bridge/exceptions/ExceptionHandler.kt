package bridge.exceptions

class ExceptionHandler {

    fun checkSize(num: Int) {
        require(num in 3..20) { "3 ~ 20 사이의 숫자를 입력해 주세요" }
    }

    fun checkUpDown(str: String) {
        require(str == "U" || str == "D") { "U 또는 D 를 눌러 주세요" }
    }

    fun checkCommand(str: String) {
        require(str == "Q" || str == "R") { "Q 또는 R 를 눌러 주세요" }
    }


}