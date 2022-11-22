package bridge.domain

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {
    private var tryNumber = 1

    // 사용자가 칸을 이동할 때 사용하는 메서드
    fun move(actual: String, predict: String): Boolean {
        return actual == predict
    }

    // 사용자가 게임을 다시 시도할 때 사용하는 메서드
    fun retry() {
        tryNumber++
    }

    fun getTryNumber(): Int {
        return tryNumber
    }
}
