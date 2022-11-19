package bridge

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {

    fun printStartMessage() {
        println("다리 건너기 게임을 시작합니다.")
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(playerResult: ArrayList<Pair<String, Boolean>>) {
        val firstRow = StringBuilder()
        val secondRow = StringBuilder()
        firstRow.append("[")
        secondRow.append("[")
        for (stage in 0 until playerResult.size - 1) {
            if (playerResult[stage].first == "U") {
                firstRow.append(" O |")
                secondRow.append("   |")
                continue
            }
            firstRow.append("   |")
            secondRow.append(" O |")
        }
        if (playerResult[playerResult.size - 1].first == "U") {
            if (playerResult[playerResult.size - 1].second) firstRow.append(" O ]")
            else firstRow.append(" X ]")
            secondRow.append("   ]")
        } else {
            if (playerResult[playerResult.size - 1].second) secondRow.append(" O ]")
            else secondRow.append(" X ]")
            firstRow.append("   ]")
        }
        firstRow.append('\n').append(secondRow)
        println(firstRow.toString())
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult() {}
}
