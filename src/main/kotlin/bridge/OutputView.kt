package bridge

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    fun startgame () {
        println("다리 건너기 게임을 시작합니다.\n")}
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(output: MutableList<Pair<String, String>>, size : Int) {
        print("[")
        for (i in 0..size-1 step 1) { print("${output[i].first}|") }
        print("${output[size].first}]\n")
        print("[")
        for (i in 0..size-1 step 1) { print("${output[i].second}|") }
        print("${output[size].second}]\n")
        println("")
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult1(output: MutableList<Pair<String, String>>, size : Int) {
        println("최종 게임 결과")
        printMap(output, size - 1)
    }

    fun printResult2(done: String, playround: Int,) {
        println("\n게임 성공 여부: ${done}")
        println("총 시도한 횟수: ${playround}")
    }
}

