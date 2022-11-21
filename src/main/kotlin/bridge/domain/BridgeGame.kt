package bridge.domain

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {
    private var tryNumber = 1

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(actual: String, predict: String): Boolean {
        return actual == predict
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {
        tryNumber++
        println("현재까지 시도한 횟수: $tryNumber")
    }

    fun getTryNumber(): Int {
        return tryNumber
    }
}
