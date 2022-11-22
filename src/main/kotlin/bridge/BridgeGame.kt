package bridge

import service.Message

class BridgeGame {
    private var tryCount: Int = 1   // 총 시도 횟수
    private var moves: MutableList<String> = mutableListOf()    // 이동 방법

    fun move(location: String) {
        moves.add(location)
    }

    fun getState(bridge: List<String>): Pair<String, String> {
        val upperState = makeUpperState(bridge)
        val lowerState = makeLowerState(bridge)
        return Pair(modifySuffix(upperState), modifySuffix(lowerState))
    }

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

    private fun compareBridgeWithMoves(bridge: List<String>): List<Int> {
        val match = mutableListOf<Int>()
        for (i in moves.indices) {
            // 1이면 같고, 0이면 다른 값
            match.add(if (bridge[i] == moves[i]) 1 else 0)
        }
        return match
    }

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

    private fun modifySuffix(state: String): String {
        val result = state.toCharArray()
        result[state.length - 1] = ']'
        return String(result)
    }
}
