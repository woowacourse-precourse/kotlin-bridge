package output

enum class ErrorMessage(val errorMessage: String) {
    RQ("[ERROR] R 혹은 Q만 입력해주세요."),
    UD("[ERROR] U 혹은 D만 입력해주세요."),
    RANGE("[ERROR] 3에서 20 사이의 수를 입력하세요."),
    ONLY_NUMBER("[ERROR] 숫자만 입력하세요.")
}