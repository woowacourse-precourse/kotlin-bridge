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

    private fun judge(route: String, bridge: String, direction: String): String {
        return if (route == direction && bridge == direction) {
            "O "
        } else if (route == direction && bridge != direction) {
            "X "
        } else {
            "  "
        }
    }
    fun printMap(route: List<String>, bridge: List<String>) {
        print("[ ")
        for (i in route.indices) {
            print(judge(route[i], bridge[i], "U")+ if (i != route.lastIndex) "| " else "")
        }
        print("]\n[ ")
        for (i in route.indices) {
            print(judge(route[i], bridge[i], "D") + if (i != route.lastIndex) "| " else "")
        }
        println("]")
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult() {}
}
