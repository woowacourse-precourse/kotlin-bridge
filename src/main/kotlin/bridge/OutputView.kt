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
    fun printMap(inputBridge: List<String>) {
        var upList = listOf<String>()
        var downList = listOf<String>()

        var middleString = "|"

        upList = upList.plus("")
        downList = downList.plus("")

        inputBridge.forEachIndexed { index, it ->
            when (it) {
                "U" -> {
                    upList = upList.plus("O")
                    downList = downList.plus(" ")
                }
                "D" -> {
                    upList = upList.plus(" ")
                    downList = downList.plus("O")
                }
                "UX" -> {
                    upList = upList.plus("X")
                    downList = downList.plus(" ")
                }
                "DX" -> {
                    upList = upList.plus(" ")
                    downList = downList.plus("X")
                }
            }
            if (index != inputBridge.size - 1) {
                upList = upList.plus(middleString)
                downList = downList.plus(middleString)
            }
        }

        upList = upList.plus("")
        downList = downList.plus("")

        val formattedUpString: String = upList.toString()
            .replace(",", "")
            .trim()

        val formattedDownString: String = downList.toString()
            .replace(",", "")
            .trim()

        println(formattedUpString)
        println(formattedDownString)
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(inputBridge: List<String>, success: Boolean, trial: Int) {
        println("\n최종 게임 결과")
        printMap(inputBridge)
        when (success) {
            true -> println("\n게임 성공 여부: 성공")
            false -> println("\n게임 성공 여부: 실패")
        }
        println("총 시도한 횟수: $trial")
    }

    fun printGameStart() {
        println("다리 건너기 게임을 시작합니다.\n")
        println("다리의 길이를 입력해주세요.")
    }
}
