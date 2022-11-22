package bridge

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {

    private fun oxJudge(route: String, bridge: String, direction: String): String {
        return if (route == direction && bridge == direction) {
            "O "
        } else if (route == direction) {
            "X "
        } else {
            "  "
        }
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    private var able1 = mutableListOf<String>()
    private var able2 = mutableListOf<String>()

    fun printMap(route: List<String>, bridge: List<String>) {

        if (route[route.lastIndex] == "U") {
            able1.add(oxJudge(route[route.lastIndex], bridge[route.lastIndex], "U"))
            able2.add("  ")
        } else if (route[route.lastIndex] == "D") {
            able1.add("  ")
            able2.add(oxJudge(route[route.lastIndex], bridge[route.lastIndex], "D"))
        }

        println(able1.joinToString(prefix = "[ ", separator = "| ", postfix = "]"))
        println(able2.joinToString(prefix = "[ ", separator = "| ", postfix = "]"))

    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult() {
    }
}
