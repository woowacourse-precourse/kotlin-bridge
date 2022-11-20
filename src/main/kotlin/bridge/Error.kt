package bridge

enum class Error(val info:String) {
    NOT_INT("[ERROR] 정수가 아닙니다."),
    NOT_IN_RANGE("[ERROR] 범위가 잘못되었습니다."),
    NOT_UD("[ERROR] U 혹은 D를 입력하지 않으셨습니다."),
    NOT_RQ("[ERROR] R 혹은 Q를 입력하지 않으셨습니다.")
}