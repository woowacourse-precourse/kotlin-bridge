package bridge

class ErrorMessage {
    private val Error = "[ERROR]"
    val onlyNumber = Error+"숫자만 입력해야 합니다 숫자 범위는 3~20입니다"
    val wrongNumber = Error+"숫자 범위는 3~20입니다"
    val wrongMove = Error+"U, D만 입력가능합니다"
    val wrongcommand = Error+"R, Q만 입력가능합니다"
}