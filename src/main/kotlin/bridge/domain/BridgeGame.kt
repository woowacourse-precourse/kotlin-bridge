package bridge.domain

import bridge.view.InputView

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(private val player: Player) {
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(bridge: Bridge, inputMoving: String): Player {
        if (bridge.match(inputMoving)) {
            player.updateStage(inputMoving)
        } else {
            player.updateStage(inputMoving + FAIL_TO_CORRECT)
        }
        return player
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {}

    fun isClear(bridge: Bridge): Boolean {
        return player.isClear(bridge.getBridge())
    }

    companion object {
        const val FAIL_TO_CORRECT = "F"
    }
}
