package view

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {

    fun printGameStartNotification() {
        println("다리 건너기 게임을 시작합니다.\n")
    }

    fun printMap(ox: List<MutableList<String>>) {
        printGameResult(ox)
    }

    fun printResult(ox: List<MutableList<String>>, count: Int, isSuccesss: String) {
        var isSuccess = "성공"
        if (isSuccesss == "FAIL") {
            isSuccess = "실패"
        }
        println("최종 게임 결과")
        printGameResult(ox)
        println("게임 성공 여부: $isSuccess")
        println("총 시도한 횟수: $count")
    }

    private fun printGameResult(ox: List<MutableList<String>>) {
        for (i in 0..1) {
            print("[ ")
            print(ox[i].toString().replace(",", " |").removePrefix("[").removeSuffix("]"))
            print(" ]")
            println()
        }
        println()
    }
}
