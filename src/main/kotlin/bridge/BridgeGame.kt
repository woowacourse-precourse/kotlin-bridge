package bridge

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
    fun move(move: String, bridge: MutableList<String>): MutableList<String> {
        if (move!="U" && move!="D") {
            println("[ERROR] 이동할 칸은 U와 D만 입력 가능합니다.")
            throw IllegalArgumentException()
        }
        bridge.add(move)
        return bridge
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {}

    fun isRight(bridge: List<String>, nowBridge: MutableList<String>): Boolean {
        for (i in 0 until nowBridge.size) {
            if (bridge[i] != nowBridge[i]) {
                return false
            }
        }
        return true
    }


}
