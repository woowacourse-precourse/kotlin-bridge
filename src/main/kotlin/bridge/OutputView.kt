package bridge

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    private fun printSingleBridge(userStep: MutableList<Pair<String, Boolean>>, side: String) {
        print("[ ")
        for (i in userStep.indices) {
            if (side != userStep[i].first) continue
            print(if (userStep[i].second) "O" else "X")
            print(if (i == 0) "" else " | ")
        }
        println(" ]")
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    fun printMap(userStep: MutableList<Pair<String, Boolean>>) {
        printSingleBridge(userStep, "U")
        printSingleBridge(userStep, "D")
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(userStep: MutableList<Pair<String, Boolean>>) {
        println("최종 게임 결과")
        printMap(userStep)
        println("게임 성공 여부: ${if (userStep.map { it.second }.contains(false)) "실패" else "성공"}")
        println("총 시도한 횟수: ${userStep.size}")
    }
}
