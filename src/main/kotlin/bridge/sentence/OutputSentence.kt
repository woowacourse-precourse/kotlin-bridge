package bridge.sentence

enum class OutputSentence(private val sentence: String) {
    RESULT("최종 게임 결과"),
    START("다리 건너기 게임을 시작합니다."),
    CHECK_SUCCESS("게임 성공 여부: "),
    TOTAL_TRIAL("총 시도한 횟수: ");

    fun sentence() = sentence

    fun print() = println(sentence)
}