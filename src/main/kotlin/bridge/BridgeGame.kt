package bridge

import bridge.util.QUIT_COMMAND
import bridge.util.RESTART_COMMAND
import bridge.validator.BridgeGameValidator

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * 일치했을 때 (true) - 다음 라운드 반환
     * 틀렸을 때 (false) - 현재 라운드 반환
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(isMatched: Boolean): Int {
        return BridgeGameValidator.validateMoveOutput(isMatched)
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    fun retry(gameCommand: String): Boolean {
        if (gameCommand == QUIT_COMMAND) {
            println("종료")
        }
        if (gameCommand == RESTART_COMMAND) return true
        return false
    }

}
