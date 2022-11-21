package bridge

import bridge.Constants.Companion.DOWN
import bridge.Constants.Companion.UP

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

    fun move(userDirection: String, createdBridge: List<String>, index: Int) : MutableMap<String, String> {

        val selectedBridge = mutableMapOf<String, String>()

        if (userDirection == createdBridge[index]) {
            if (userDirection == UP) {
                selectedBridge[UP] = "O"
                selectedBridge[DOWN] = " "
            } else {
                selectedBridge[UP] = " "
                selectedBridge[DOWN] = "O"
            }
        } else {
            if (userDirection == UP) {
                selectedBridge[UP] = "X"
                selectedBridge[DOWN] = " "
            } else {
                selectedBridge[UP] = " "
                selectedBridge[DOWN] = "X"
            }
        }
        return selectedBridge
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {}
}
