package bridge

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(moves: List<String>, answers: List<String>) {
        upMove(moves, answers)
        downMove(moves, answers)
    }

    private fun upMove(moves: List<String>, answers: List<String>) {
        var upMove = ""
        for (stepIndex in moves.indices) {
            upMove += getUpOX(moves[stepIndex], answers[stepIndex])
            if (stepIndex != moves.lastIndex) {
                upMove += "|"
            }
        }
        println("[$upMove]")
    }

    private fun downMove(moves: List<String>, answers: List<String>) {
        var downMove = ""
        for (stepIndex in moves.indices) {
            downMove += getDownOX(moves[stepIndex], answers[stepIndex])
            if (stepIndex != moves.lastIndex) {
                downMove += "|"
            }
        }
        println("[$downMove]")
    }

    private fun getUpOX(moveValue: String, answerValue: String): String {
        if (moveValue == "U") {
            if (moveValue == answerValue) {
                return " O "
            }
            return " X "
        }
        return "   "
    }

    private fun getDownOX(moveValue: String, answerValue: String): String {
        if (moveValue == "D") {
            if (answerValue == "D") {
                return " O "
            }
            return " X "
        }
        return "   "
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(moves: List<String>, answers: List<String>, attempts: Int) {
        println("최종 게임 결과")
        printMap(moves, answers)
        val crossResult = successOrFailure(moves, answers)
        println("\n게임 성공 여부: $crossResult")
        println("총 시도한 횟수: $attempts")
    }

    fun successOrFailure(moves: List<String>, answers: List<String>): String {
        for (attempt in moves.indices) {
            if (moves[attempt] != answers[attempt]) {
                return "실패"
            }
        }
        return "성공"
    }
}
