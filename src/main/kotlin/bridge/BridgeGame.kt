package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(private val bridge: List<String>) {

    private val moves: MutableList<String> = mutableListOf()

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     */
    fun move(idx: Int, moving: String): Boolean {
        moves.add(moving)
        if(moving == bridge[idx]) return true
        return false
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    fun retry() {
        moves.clear()
    }
}
