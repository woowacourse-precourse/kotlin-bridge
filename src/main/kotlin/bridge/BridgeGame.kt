package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(private val bridge: List<String>) {
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     */
    var index = 0
    fun move(moving: String): Boolean {
        return moving == bridge[index++]
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    fun retry() {}
}
