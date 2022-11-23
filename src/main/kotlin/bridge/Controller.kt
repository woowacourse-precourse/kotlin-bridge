package bridge

// BridgeGame과 View들을 이어주는 class
class Controller {
    // 이동할 방향 입력(U/D)
    fun writeMoving(): String {
        return InputView().readMoving()
    }
    // 게임 진행 여부 입력(R/Q)
    fun writeGameCommand(): String {
        return InputView().readGameCommand()
    }
    //게임이 끝났을 때 실행
    fun doneGame(size: Int, countTry: Int) {
        when (size) {
            // list의 size가 0 == 성공
            0 -> println(Comment.GameComment.WIN.message + Result.SUCCESS.word)
            // list의 size가 !0 == 실패
            else -> println(Comment.GameComment.WIN.message + Result.FAIL.word)
        }
        // 도전횟수 멘트 및 도전횟수 출력
        println(Comment.GameComment.COUNT.message + countTry)
    }

    // 현재 정오표 출력
    fun readCurrent(currentBridge: List<String>, currentSquare: List<Boolean>) {
        OutputView().printMap(currentBridge, currentSquare)
    }
    // 최종 정오표 출력
    fun readResult(currentBridge: List<String>, currentSquare: List<Boolean>) {
        println(Comment.GameComment.RESULT.message)
        OutputView().printResult(currentBridge, currentSquare)
    }
    // "성공", "실패"
    enum class Result(val word: String) {
        SUCCESS("성공"),
        FAIL("실패"),
    }
}