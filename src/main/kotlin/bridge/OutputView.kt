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
        var upList = separteToUpList(inputBridge)
        var downList = separteToDownList(inputBridge)

        println(formatString(upList))
        println(formatString(downList))
    }

    private fun separteToUpList(inputBridge: List<String>): List<String> {
        var upList = listOf("")
        inputBridge.forEachIndexed { index, it ->
            upList = changeUpToOX(it, upList)
            upList = addMiddleSeperator(index, inputBridge, upList)
        }
        upList = upList.plus("")
        return upList
    }

    private fun changeUpToOX(it: String, upList: List<String>): List<String> {
        var upList = upList
        when (it) {
            "U" -> upList = upList.plus("O")
            "D" -> upList = upList.plus(" ")
            "UX" -> upList = upList.plus("X")
            "DX" -> upList = upList.plus(" ")
        }
        return upList
    }

    private fun separteToDownList(inputBridge: List<String>): List<String> {
        var downList = listOf("")
        inputBridge.forEachIndexed { index, it ->
            downList = changeDownToOX(it, downList)
            downList = addMiddleSeperator(index, inputBridge, downList)
        }
        downList = downList.plus("")
        return downList
    }

    private fun changeDownToOX(it: String, downList: List<String>): List<String> {
        var downList = downList
        when (it) {
            "U" -> downList = downList.plus(" ")
            "D" -> downList = downList.plus("O")
            "UX" -> downList = downList.plus(" ")
            "DX" -> downList = downList.plus("X")
        }
        return downList
    }

    private fun addMiddleSeperator(index: Int, inputBridge: List<String>, list: List<String>): List<String> {
        var list = list
        if (index != inputBridge.size - 1)
            list = list.plus("|")
        return list
    }

    private fun formatString(list: List<String>): String {
        return list.toString()
            .replace(",", "")
            .trim()
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
