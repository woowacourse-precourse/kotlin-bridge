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
    private var idx = 0
    private val upResultList = mutableListOf<String>()
    private val downResultList = mutableListOf<String>()

    fun move(userDirection: String, createdBridge: List<String>){
        if (userDirection == createdBridge[idx]) {
            saveUserCorrectedDirection(userDirection)
            idx += 1
        } else {
            saveUserIncorrectedDirection(userDirection)
        }
    }

    fun saveUserCorrectedDirection(userDirection: String){
        if (userDirection == UP) {
            upResultList.add(CORRECT_MARK)
            downResultList.add(BLANK)
        } else {
            upResultList.add(BLANK)
            downResultList.add(CORRECT_MARK)
        }
    }

    fun saveUserIncorrectedDirection(userDirection: String){
        if (userDirection == UP) {
            upResultList.add(INCORRECT_MARK)
            downResultList.add(BLANK)
        } else {
            upResultList.add(BLANK)
            downResultList.add(INCORRECT_MARK)
        }
    }

    fun saveLastResult() : MutableMap<String, List<String>>{
        val selectedBridge = mutableMapOf<String, List<String>>()
        selectedBridge[UP] = upResultList
        selectedBridge[DOWN] = downResultList
        return selectedBridge
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {
        upResultList.clear()
        downResultList.clear()
    }

    companion object {
        const val CORRECT_MARK = "O"
        const val INCORRECT_MARK = "X"
        const val BLANK = " "
    }

}
