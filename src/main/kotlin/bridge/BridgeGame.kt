package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {

    fun move(playerInput:String,bridge:Bridge) {
        bridge.movePlayer(playerInput)

    }
    fun retry() {

    }

}
