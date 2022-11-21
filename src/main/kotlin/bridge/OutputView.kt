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
    fun printMap(bridgeAnswer : List<String>, currentMove : Boolean, turnCount : Int) {
    }

    fun upperSide(bridgeAnswer : List<String>, currentMove : Boolean, turnCount : Int): List<String> {
        val bridgeUpperSide = mutableListOf<String>()
        for (turn in 0 until  turnCount){
            if (bridgeAnswer[turn] == "U") bridgeUpperSide.add("O")
            if (bridgeAnswer[turn] == "D") bridgeUpperSide.add(" ")
            bridgeUpperSide.add(" | ")
        }
        if ((bridgeAnswer[turnCount] == "U") && currentMove) bridgeUpperSide.add("O")
        if ((bridgeAnswer[turnCount] == "U") && !currentMove) bridgeUpperSide.add("X")
        return bridgeUpperSide.toList()
    }

    fun downSide (bridgeAnswer : List<String>, currentMove : Boolean, turnCount : Int): List<String> {
        val bridgeDownSide = mutableListOf<String>()
        for (turn in 0 .. turnCount){
            if (bridgeAnswer[turn] == "D") bridgeDownSide.add("O")
            if (bridgeAnswer[turn] == "U") bridgeDownSide.add(" ")
            bridgeDownSide.add(" | ")
        }
        if ((bridgeAnswer[turnCount] == "D") && currentMove) bridgeDownSide.add("O")
        if ((bridgeAnswer[turnCount] == "D") && !currentMove) bridgeDownSide.add("X")
        return bridgeDownSide.toList()
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult() {}
}
