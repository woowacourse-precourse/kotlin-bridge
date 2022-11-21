package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame() {
    private val tryCount: Int = 1   // 총 시도 횟수
    private val moves: MutableList<String> = mutableListOf()    // 이동 방법

    /**
     * 사용자가 칸을 이동할 때 사용
     * BridgeGame이 관리하는 moves에 추가
     */
    fun move(location: String) {
        moves.add(location)
    }

    /**
     * 다리 상태와 입력의 비교 값을 리스트로 반환
     * 같으면 1 다르면 0
     */
    fun compareBridgeWithMoves(bridge: List<String>): List<Int> {
        val match = mutableListOf<Int>()
        for (i in moves.indices) {
            // 1이면 같고, 0이면 다른 값
            match.add(if (bridge[i] == moves[i]) 1 else 0)
        }
        return match
    }

    /**
     * 전체 다리 상태 반환
     */
    fun getState(bridge: List<String>): Pair<String, String> {
        val upperState = makeUpperState(bridge)
        val lowerState = makeLowerState(bridge)
        return Pair(modifySuffix(upperState), modifySuffix(lowerState))
    }

    /**
     * 위쪽 다리 상태 반환
     */
    private fun makeUpperState(bridge: List<String>): String {
        var upperState = "["
        val match = compareBridgeWithMoves(bridge)
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
    private fun makeLowerState(bridge: List<String>): String {
        var lowerState = "["
        val match = compareBridgeWithMoves(bridge)
        for (i in match.indices) {
            lowerState += (if (match[i] == 1 && moves[i] == "U") "   |"
            else if (match[i] == 1 && moves[i] == "D") " O |"
            else if (match[i] == 0 && moves[i] == "U") "   |"
            else " X |")
        }
        return lowerState
    }

    /**
     * 마지막 값을 ']'로 변환
     */
    fun modifySuffix(state: String): String {
        val result = state.toCharArray()
        result[state.length - 1] = ']'
        return String(result)
    }

    fun isFail(bridge: List<String>): Boolean = (compareBridgeWithMoves(bridge)).contains(0)

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    fun retry() {}
}
