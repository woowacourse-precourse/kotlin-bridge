package bridge

class OutputView {
    fun printMap(state: Pair<String, String>) {
        println(state.first)
        println(state.second)
    }

    fun printResult(result: String) {
        println(result)
    }
}
