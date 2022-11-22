package bridge

import service.Message

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {
    private var tryCount: Int = 1   // 총 시도 횟수
    private var moves: MutableList<String> = mutableListOf()    // 이동 방법

    /**
     * 사용자가 칸을 이동할 때 사용
     * BridgeGame의 멤버변수 moves에 추가
     */
    fun move(location: String) {
        moves.add(location)
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
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    fun retry(restartCommand: String): Boolean {
        if (restartCommand == "R") {
            tryCount += 1
            moves = mutableListOf()
            return true
        }
        return false
    }

    fun isFail(bridge: List<String>): Boolean = (compareBridgeWithMoves(bridge)).contains(0)

    fun isSuccess(bridge: List<String>): Boolean =
            !(compareBridgeWithMoves(bridge)).contains(0)
                    && bridge.size == moves.size

    fun getResult(bridge: List<String>): String {
        val state = getState(bridge)
        return "최종 게임 결과\n${state.first}\n${state.second}"
    }

    fun getAnalysis(isSuccess: Boolean): String {
        return if (isSuccess) Message.BridgeGameEnum.SUCCESS.toString().format(tryCount)
        else Message.BridgeGameEnum.FAIL.toString().format(tryCount)
    }

    /**
     * 다리 상태와 입력의 비교 값을 리스트로 반환
     * 같으면 1 다르면 0
     */
    private fun compareBridgeWithMoves(bridge: List<String>): List<Int> {
        val match = mutableListOf<Int>()
        for (i in moves.indices) {
            // 1이면 같고, 0이면 다른 값
            match.add(if (bridge[i] == moves[i]) 1 else 0)
        }
        return match
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
    private fun modifySuffix(state: String): String {
        val result = state.toCharArray()
        result[state.length - 1] = ']'
        return String(result)
    }
}
