package bridge.sentence

enum class ErrorSentence(private val sentence: String) {
    BRIDGE_LENGTH("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    MOVE("[ERROR] U(위 칸), D(아래 칸) 중 하나의 문자를 입력해주세요."),
    MOVE_NUMBER("[ERROR] 건널 수 있는 다리는 0(아래 칸), 1(위 칸) 입니다."),
    RESTART("[ERROR] R(재시작), Q(종료) 중 하나의 문자를 입력해주세요.");

    fun sentence() = sentence
}