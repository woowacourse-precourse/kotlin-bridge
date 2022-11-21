package bridge

import bridge.enum.BridgeEnum

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(private val bridge: List<String>) {
    val up = mutableListOf<String>()
    val down = mutableListOf<String>()
    var index = 0

    private val movable = BridgeEnum.MOVABLE.value
    private val unselected = BridgeEnum.UNSELECTED.value
    private val unmovable = BridgeEnum.UNMOVABLE.value

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     */
    fun move(moving: String) {
        val isMovable = (moving == bridge[index])
        if (bridge[index++] == BridgeEnum.UP.value) {
            up.add(if (isMovable) movable else unselected)
            down.add(if (isMovable) unselected else unmovable)
        } else {
            up.add(if (isMovable) unselected else unmovable)
            down.add(if (isMovable) movable else unselected)
        }
    }

    /**
     * 게임의 진행상황을 결정하는 메서드 (실패/성공/진행)
     */
    fun isGameContinue(): String {
        if (up.last() == unmovable || down.last() == unmovable) return "FAIL"
        if (index == bridge.size) return "SUCCESS"
        return "CONTINUE"
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    fun retry() {
        up.clear()
        down.clear()
        index = 0
    }
}
