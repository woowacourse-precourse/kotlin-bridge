package bridge.ui.view


/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(bridgeCrossingInfo: List<Boolean>, userMovingInfo: List<String>) {
        println(bridgeCrossingInfo)
        val round = bridgeCrossingInfo.size

        val isPrintedRoundOf = MutableList(round) { false }

        // 윗 다리
        // TODO : U 일때만 출력
        print("[ ")
        bridgeCrossingInfo.forEachIndexed { curRound, isCrossed ->
            if (userMovingInfo[curRound] == "U") {
                if (isCrossed) print("O")
                else print("X")
            }

            else print(" ")

            if (curRound + 1 == round) print(" ]\n")
            else print(" | ")

            // if (isPrintedRoundOf[curRound]) print(" ")

//            else {
//                if (isCrossed) print("O")
//                else print("X")
//                isPrintedRoundOf[curRound] = true
//            }
//
//            if (curRound + 1 == round) print(" ]\n")
//            else print(" | ")
        }

        // 아랫 다리
        print("[ ")
        bridgeCrossingInfo.forEachIndexed { curRound, isCrossed ->
            if (userMovingInfo[curRound] == "D") {
                if (isCrossed) print("O")
                else print("X")
            }

            else print(" ")

            if (curRound + 1 == round) print(" ]\n")
            else print(" | ")
//            if (isPrintedRoundOf[curRound]) print(" ")
//
//            else {
//                if (isCrossed) print("O")
//                else print("X")
//                isPrintedRoundOf[curRound] = true
//            }
//
//            if (curRound + 1 == round) print(" ]\n")
//            else print(" | ")
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult() {}

    fun printMessage(message: String) = print(message)
}
