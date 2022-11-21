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
    fun printMap(
        currentBridge: List<String>,
        answerBridge: List<String>
    ) {
        if(currentBridge.size > answerBridge.size){
            throw java.lang.IllegalStateException("[ERROR] 현재 다리의 길이가 정답의 길이보다 깁니다.")
        }

        val upBridge = mutableListOf<String>()
        val downBridge = mutableListOf<String>()
        val bridgeState = listOf(upBridge, downBridge)

        currentBridge.forEachIndexed { index, s ->
            val curState = when (s) {
                answerBridge[index] -> "O"
                else -> "X"
            }
            val idx = when(s){
                "U" -> 0
                "D" -> 1
                else -> throw java.lang.IllegalStateException("[ERROR] 잘못된 다리의 상태를 갖고 있습니다.")
            }

            bridgeState[idx].add(" $curState ")
            bridgeState[idx xor 1].add("   ")
        }

        println("[ ${bridgeState[0].joinToString(" | ")} ]")
        println("[ ${bridgeState[1].joinToString(" | ")} ]")
        println()
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(isFullEnded: Boolean, turn: Int) {
        val isFullEndedString = if (isFullEnded) "성공" else "실패"
        println("게임 성공 여부: $isFullEndedString")
        println("총 시도한 횟수: $turn")
    }
}
