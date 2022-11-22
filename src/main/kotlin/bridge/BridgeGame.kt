package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {
    private var playerTryCount=1

    fun move(playerInput:String,bridge:Bridge) {
        bridge.movePlayer(playerInput)

    }
    fun retry(bridge: Bridge) {
        bridge.resetPlayer()
        playerTryCount++
    }

}
