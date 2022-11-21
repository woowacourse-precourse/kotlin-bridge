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
    fun printMap(bridge: List<String>, moves: List<String>) {
        val match = compareBridgeWithMoves(bridge, moves)
        val upperState = makeUpperState(match, moves)
        val lowerState = makeLowerState(match, moves)
        println(modifySuffix(upperState))
        println(modifySuffix(lowerState))
    }

    /**
     * 위쪽 다리 상태 반환
     */
    private fun makeUpperState(match: List<Int>, moves: List<String>): String {
        var upperState = "["
        for (i in match.indices) {
            upperState += (if (match[i] == 1 && moves[i] == "U") " O |"
            else if (match[i] == 1 && moves[i] == "D") "   |"
            else if (match[i] == 0 && moves[i] == "U") " X |"
            else "   |")
        }
        return upperState
    }

    /**
     * 아래쪽 다리 상태 반환
     */
    private fun makeLowerState(match: List<Int>, moves: List<String>): String {
        var lowerState = "["
        for (i in match.indices) {
            lowerState += (if (match[i] == 1 && moves[i] == "U") "   |"
            else if (match[i] == 1 && moves[i] == "D") " O |"
            else if (match[i] == 0 && moves[i] == "U") "   |"
            else " X |")
        }
        return lowerState
    }

    /**
     * 다리 상태와 입력의 비교 값을 리스트로 반환
     * 같으면 1 다르면 0
     */
    private fun compareBridgeWithMoves(bridge: List<String>, moves: List<String>): List<Int> {
        val match = mutableListOf<Int>()
        for (i in moves.indices) {
            // 1이면 같고, 0이면 다른 값
            match.add(if (bridge[i] == moves[i]) 1 else 0)
        }
        return match
    }

    /**
     * 마지막 값을 ']'로 변환
     */
    fun modifySuffix(state: String): String {
        val tmp = state.toCharArray()
        tmp[state.length - 1] = ']'
        return String(tmp)
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult() {}
}
