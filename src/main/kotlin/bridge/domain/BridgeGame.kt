package bridge.domain

/**
 * 다리 건너기 게임을 관리하는 클래스
 *
 * 요구사항 ⬇
 *
 * 제공된 BridgeGame 클래스를 활용해 구현해야 한다.
 *
 * BridgeGame에 필드를 추가할 수 있다.
 *
 * BridgeGame의 패키지는 변경할 수 있다.
 *
 * BridgeGame의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
 *
 * BridgeGame의 클래스에서 InputView, OutputView 를 사용하지 않는다.
 *
 * 게임 진행을 위해 필요한 메서드를 추가하거나 변경 할 수 있다.
 */
class BridgeGame(private val answerBridge: List<String>) {

    private var position = 0
    private var tryCount = 1

    fun move(direction: String): Boolean {
        if (answerBridge[position] == direction) {
            return true
        }
        return false
    }

    fun retry() {
        position = 0
        tryCount++
    }
}
