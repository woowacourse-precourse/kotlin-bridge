package bridge

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {

    companion object {
        var mapUp  = mutableListOf("[")
        var mapDown  = mutableListOf("[")
        fun printGameStart() {
            println("다리 건너기 게임을 시작합니다.\n")
        }

        fun messageInputBridgeSize() {
            println("다리의 길이를 입력해주세요.")
        }

        fun messageInputMove() {
            println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)")
        }

        fun messageInputGameCommand() {
            println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
        }

        fun messageGameResult() {
            println("최종 게임 결과")
        }

        /**
         * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
         *
         * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
         */
        fun printMap(inputList : MutableList<String>,bridgeList: List<String>, index : Int) {
            mapUp  = mutableListOf("[")
            mapDown  = mutableListOf("[")
            for (i in 0..index) {
                checkLast(mapUp,mapDown)
                checkUp(inputList,bridgeList,i)
                checkDown(inputList,bridgeList,i)
            }
            println(mapUp.joinToString(" "))
            println(mapDown.joinToString(" "))
        }
        fun checkLast(mapUp:MutableList<String> ,mapDown : MutableList<String>) {
            if (mapUp.last() == "]") {
                mapUp.removeLast()
                mapUp.add("|")
            }
            if (mapDown.last() == "]") {
                mapDown.removeLast()
                mapDown.add("|")
            }
        }
        fun checkUp(inputList: MutableList<String>, bridgeList: List<String>, i : Int){
            if (inputList[i] == "U" && bridgeList[i] == "U") {
                mapUp.addAll(listOf("O","]"))
                mapDown.addAll(listOf(" ","]"))
            }
            if (inputList[i] == "U" && bridgeList[i] == "D") {
                mapUp.addAll(listOf("X","]"))
                mapDown.addAll(listOf(" ","]"))
            }
        }
        fun checkDown(inputList: MutableList<String>, bridgeList: List<String>, i : Int){
            if (inputList[i] == "D" && bridgeList[i] == "D") {
                mapUp.addAll(listOf(" ", "]"))
                mapDown.addAll(listOf("O", "]"))
            }
            if (inputList[i] == "D" && bridgeList[i] == "U") {
                mapUp.addAll(listOf(" ", "]"))
                mapDown.addAll(listOf("X", "]"))
            }
        }
        /**
         * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
         *
         * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
         */
        fun printResult(count :Int,success:Int) {
            println("\n최종 게임 결과")
            println(mapUp.joinToString(" "))
            println(mapDown.joinToString(" "))
            println()
            var result = "실패"
            if (success == 1)
                result = "성공"
            println("게임 성공 여부: $result")
            println("총 시도한 횟수: $count")
        }
    }
}
