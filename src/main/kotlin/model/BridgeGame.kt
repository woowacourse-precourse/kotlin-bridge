package model

import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator
import utils.Messages.MOVE_DOWN
import utils.Messages.MOVE_FAIL
import utils.Messages.MOVE_SUCCESS
import utils.Messages.MOVE_UP
import utils.Messages.RESTART

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
    fun move(moveInput: String, answerMoveSingle: String): HashMap<String, String> {
        val resultHashMap = HashMap<String, String>()
        when {
            (moveInput == answerMoveSingle) && (moveInput == MOVE_UP) -> resultHashMap[MOVE_UP] = MOVE_SUCCESS
            (moveInput == answerMoveSingle) && (moveInput == MOVE_DOWN) -> resultHashMap[MOVE_DOWN] = MOVE_SUCCESS
            (moveInput != answerMoveSingle) && (moveInput == MOVE_UP) -> resultHashMap[MOVE_UP] = MOVE_FAIL
            (moveInput != answerMoveSingle) && (moveInput == MOVE_DOWN) -> resultHashMap[MOVE_DOWN] = MOVE_FAIL
        }
        return resultHashMap
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry(inputGameRestartCommand: String): Boolean {
        if (inputGameRestartCommand == RESTART) {
            return true // true
        }
        return false // false
    }

    fun getAnswerMove(bridgeSize: Int): List<String> {
        val bridge = BridgeMaker(BridgeRandomNumberGenerator()) // 상속과 반환!? : 뒤에?!
        val answerMove = bridge.makeBridge(bridgeSize) // [U, D, U] 이런 식으로 현재 리스트가 만들어짐
        println(answerMove)
        return answerMove
    }
}
