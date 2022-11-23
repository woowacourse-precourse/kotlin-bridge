package bridge

class OutputView {
    // 게임 시작 멘트
    fun printGameStart() {
        println(Comment.GameComment.START.message)
    }
    // List<boolean> : (true/false) -> ("O"/"X")
    private fun makeHit(currentSquare: Boolean): String {
        val hit = when (currentSquare) {
            true -> SpecialSymbols.ANSWER.word
            false -> SpecialSymbols.MISTAKE.word
        }
        return hit
    }
    // [] <- 위쪽 line 출력 함수
    // []
    private fun printUp(word: String, currentSquare: Boolean): String {
        var mapWord = SpecialSymbols.INIT.word
        when {
            //[O]
            word == "U" && currentSquare -> mapWord = "[ ${makeHit(currentSquare)} ]"
            //[X]
            word == "U" && !currentSquare -> mapWord = "[ ${makeHit(currentSquare)} ]"
            //[ ]
            word == "D" -> mapWord = SpecialSymbols.BRACKET_BLANK.word
        }
        return mapWord
    }
    // []
    // []  <- 아래쪽 line 출력 함수
    private fun printDown(word: String, currentSquare: Boolean): String {
        var mapWord = SpecialSymbols.INIT.word
        when {
            //[O]
            word == "U" -> mapWord = SpecialSymbols.BRACKET_BLANK.word
            //[X]
            word == "D" && currentSquare -> mapWord = "[ ${makeHit(currentSquare)} ]"
            //[ ]
            word == "D" && !currentSquare -> mapWord = "[ ${makeHit(currentSquare)} ]"
        }
        return mapWord
    }
    // 양식에 맞게 가공
    private fun cutExtra(words: String) {
        // 현재 word 상태 == [O][ ][X]+[ ][O][ ]
        // word에 "]["이 있다면 "|"으로 변경
        // word에 "+"가 있다면 "\n"으로 변경(개행)
        val newWords = words.replace(SpecialSymbols.EXTRA_BRACKET.word, SpecialSymbols.DIVIDER.word)
            .replace(SpecialSymbols.PLUS.word, "\n")
        // 바로 유저에게 보여 줌
        println(newWords)
    }
    // word:String에 printUP() & printDown()의 양식을 for문을 돌면서 하나씩 저장
    //for문은 동기적으로 움직이기때문에 윗 for문이 끝나야 아래 for문이 실행되는 성질을 이용
    fun printMap(currentBridge: List<String>, currentSquare: List<Boolean>) {
        var words = SpecialSymbols.INIT.word
        for (i in currentBridge.indices) words += printUp(currentBridge[i], currentSquare[i])
        words += SpecialSymbols.PLUS.word// 개행에 사용될 "+" 추가
        for (i in currentBridge.indices) words += printDown(currentBridge[i], currentSquare[i])
        cutExtra(words)
    }
    // Q -> 실행
    fun printResult(currentBridge: List<String>, currentSquare: List<Boolean>) {
        printMap(currentBridge, currentSquare)
    }

}
// 특수 문자 모음
enum class SpecialSymbols(val word: String) {
    ANSWER("O"),
    MISTAKE("X"),
    BRACKET_BLANK("[   ]"),
    EXTRA_BRACKET("]["),
    INIT(""),
    DIVIDER("|"),
    PLUS("+")
}