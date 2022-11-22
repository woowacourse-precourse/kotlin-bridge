package view

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {

    fun printGameStartNotification() {
        println("다리 건너기 게임을 시작합니다.\n")
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(ox: List<MutableList<String>>) {
        printGameResult(ox)
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
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

// OutputView의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
// 값 출력을 위해 필요한 메서드를 추가할 수 있다.
