package bridge.domain

import bridge.common.GameState

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(private val bridge: List<String>) {
    private val _currentUpperBridge = mutableListOf<String>()
    val currentUpperBridge: List<String> get() = _currentUpperBridge

    private val _currentDownerBridge = mutableListOf<String>()
    val currentDownerBridge: List<String> get() = _currentDownerBridge

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(direction: String): GameState {
        val blockComparator = BlockComparator()
        val position = currentDownerBridge.size

        return when (direction == bridge[position]) {
            true -> isCorrect(blockComparator, direction)
            false -> isIncorrect(blockComparator, direction)
        }
    }

    private fun isCorrect(blockComparator: BlockComparator, direction: String): GameState {
        val upperResult = blockComparator.compareIsUpperCorrect(direction)
        val downerResult = blockComparator.compareIsDownerCorrect(direction)
        _currentUpperBridge.add(upperResult)
        _currentDownerBridge.add(downerResult)
        if (currentDownerBridge.size == bridge.size) return GameState.SUCCESS
        return GameState.IN_GAME
    }

    private fun isIncorrect(blockComparator: BlockComparator, direction: String): GameState {
        val upperResult = blockComparator.compareIsUpperIncorrect(direction)
        val downerResult = blockComparator.compareIsDownerIncorrect(direction)
        _currentUpperBridge.add(upperResult)
        _currentDownerBridge.add(downerResult)
        return GameState.FAILURE
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {
        _currentDownerBridge.clear()
        _currentUpperBridge.clear()
    }
}
