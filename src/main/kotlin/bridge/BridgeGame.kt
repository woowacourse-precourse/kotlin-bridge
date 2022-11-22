package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(private val answerBridge: List<String>) {
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    fun move(whereToMove: String, inputBridge: List<String>): List<String> {
        var inputBridge = inputBridge

        inputBridge = inputBridge.plus(whereToMove)
        inputBridge = checkOX(inputBridge)

        return inputBridge
    }

    private fun checkOX(inputBridge: List<String>): List<String> {
        var inputBridge = inputBridge
        var inputBridgeMutable = inputBridge.toMutableList()
        inputBridgeMutable = addX(inputBridge, inputBridgeMutable)
        return inputBridgeMutable.toList()
    }

    private fun addX(
        inputBridge: List<String>,
        inputBridgeMutable: MutableList<String>,
    ): MutableList<String> {
        inputBridge.forEachIndexed { index, it ->
            if (answerBridge[index] != it) {
                inputBridgeMutable[index] = it + "X"
            }
        }
        return inputBridgeMutable
    }

    fun checkSuccess(inputBridge: List<String>): Boolean {
        var success = true
        inputBridge.forEachIndexed { index, it ->
            if (answerBridge[index] != it) {
                success = false
            }
        }
        return success
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry(trial: Int) {
        var trial = trial
        trial += 1
        doGame(trial)
    }
}
