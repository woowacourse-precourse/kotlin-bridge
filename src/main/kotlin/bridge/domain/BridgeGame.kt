package bridge.domain

import bridge.util.*


/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(private val bride: List<String>) {

    private var _userMove = Array(BRIDGE_HEIGHT) { mutableListOf<String>() }
    val userMove: Array<MutableList<String>>
        get() = _userMove
    var gameCount = 1

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * 맞는 이동을 하면 true 값을 반환한다.
     */
    fun move(key: String, position: Int): Boolean {
        val isCorrect = match(key, position)
        // 이동한 입력값에 대한 결과 저장
        resultOfMove(key, isCorrect)
        return isCorrect
    }

     // 결과에 대한 위, 아래에 따라 맞았는지 결과를 저장한다.
    private fun resultOfMove(key: String, match: Boolean) {
        when (key) {
            UP -> {
                _userMove[0].add(convertResult(match))
                _userMove[1].add(BLANK)
            }
            DOWN -> {
                _userMove[0].add(BLANK)
                _userMove[1].add(convertResult(match))
            }
        }
    }

    private fun convertResult(match: Boolean): String {
        return if (match) CORRECT else MISS
    }

    private fun match(key: String, position: Int): Boolean {
        return bride[position] == key
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    fun retry() {
        clearUserMove()
        gameCount++
    }

    private fun clearUserMove() {
        _userMove = Array(BRIDGE_HEIGHT) { mutableListOf() }
    }
}
