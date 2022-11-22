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
    fun printMap(bridge: List<String>, nowBridge: List<String>) {
        printUpBridge(bridge, nowBridge)
        printDownBridge(bridge, nowBridge)
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(success: Boolean, tryCount: Int) {
        when (success) {
            true -> println("\n게임 성공 여부: 성공")
            false -> println("\n게임 성공 여부: 실패")
        }
        println("총 시도한 횟수: $tryCount")
    }

    fun printResultMap(bridge: List<String>, nowBridge: MutableList<String>) {
        println("\n최종 게임 결과")
        printMap(bridge, nowBridge)
    }

    private fun printUpBridge(bridge: List<String>, nowBridge: List<String>) {
        val length = nowBridge.size
        print("[")
        for (i in 0 until length) {
            if (i>0) { print("|") }
            if (nowBridge[i]=="U" && nowBridge[i]==bridge[i]) { print(" O ") }
            if (nowBridge[i]=="U" && nowBridge[i]!=bridge[i]) { print(" X ") }
            if (nowBridge[i]=="D") { print("   ") }
        }
        println("]")
    }

    private fun printDownBridge(bridge: List<String>, nowBridge: List<String>) {
        val length = nowBridge.size
        print("[")
        for (i in 0 until length) {
            if (i>0) { print("|") }
            if (nowBridge[i]=="D" && nowBridge[i]==bridge[i]) { print(" O ") }
            if (nowBridge[i]=="D" && nowBridge[i]!=bridge[i]) { print(" X ") }
            if (nowBridge[i]=="U") { print("   ") }
        }
        println("]")
    }
}
