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
    fun printMap() {}

    private fun upMove(moves: List<String>, answers: List<String>) {
        var upMove = ""
        for (stepIndex in moves.indices) {
            upMove += getUpOX(moves[stepIndex], answers[stepIndex])
            if (stepIndex != 0 && stepIndex != moves.lastIndex) {
                upMove += "|"
            }
        }
        println("[$upMove]")
    }

    private fun getUpOX(moveValue: String, answerValue: String): String {
        if (moveValue === "U" && answerValue === "U") {
            return " O "
        }
        if (moveValue == "U" && answerValue == "D") {
            return " X "
        }
        return "   "
    }

    private fun getDownOX(moveValue: String, answerValue: String): String {
        if (moveValue === "D" && answerValue === "D") {
            return " O "
        }
        if (moveValue == "D" && answerValue == "U") {
            return " X "
        }
        return "   "
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult() {}
}
