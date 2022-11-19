package bridge.domain

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {

    fun move(move: String, bridge: List<String>, player: Player) {
        player.go(move, bridge)
    }

    fun retry() {
    }
}
