package bridge

import bridge.enum.BridgeEnum

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(private val bridge: List<String>) {

    private val up = mutableListOf<String>()
    private val down = mutableListOf<String>()
    private var index = 0

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
     * 위, 아래의 다리를 list 형태에서 올바른 징검다리 형태로 바꾸어지는 메서드
     */
    fun toUpBridgeMap(): String {
        return up.toString().replace(", ","|")
    }
    fun toDownBridgeMap(): String {
        return down.toString().replace(", ","|")
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
