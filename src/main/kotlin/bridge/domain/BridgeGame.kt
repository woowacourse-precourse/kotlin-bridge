package bridge.domain

import bridge.utils.*

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(bridge: Bridge, direction: String, bridgeMaker: List<String>): String {
        val result = Judgement().compareDirection(direction, bridgeMaker[bridge.size])
        moveBridge(bridge, direction, result)
        bridge.setBridgeSize()
        return result
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry(command: String, player: Player, bridge: Bridge) {
        when (command) {
            RETRY -> setRetry(player, bridge)
            QUIT -> setQuit(player)
        }
    }

    fun isSuccess(player: Player): String {
        if (player.isGameSuccess) {
            return GAME_SUCCESS
        }
        return GAME_FAILURE
    }

    private fun moveBridge(bridge: Bridge, direction: String, result: String) {
        when (direction) {
            UP -> moveUpBridge(bridge, result)
            DOWN -> moveDownBridge(bridge, result)
        }
    }

    private fun moveUpBridge(bridge: Bridge, result: String) {
        bridge.setUpBridge(getMovingResult(bridge.size, result))
        bridge.setDownBridge(getMovingResult(bridge.size, " "))
    }

    private fun moveDownBridge(bridge: Bridge, result: String) {
        bridge.setUpBridge(getMovingResult(bridge.size, " "))
        bridge.setDownBridge(getMovingResult(bridge.size, result))
    }

    private fun getMovingResult(size: Int, result: String): String {
        if (size == ZERO) {
            return " $result "
        }
        return "| $result "
    }

    private fun setRetry(player: Player, bridge: Bridge) {
        player.setGameRetry()
        player.setRetryCount()
        bridge.resetBridge()
    }

    private fun setQuit(player: Player) {
        player.setGameFailure()
        player.setGameQuit()
    }
}
