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
    fun moveAndCheckAnswer(trial: Int) {
        var inputBridge = listOf<String>()
        var success = true
        while (success) {
            inputBridge = move(inputBridge)
            success = checkSuccess(inputBridge)
            if (inputBridge == answerBridge) {
                OutputView().printResult(inputBridge, success, trial)
                break
            }
        }
        if (!success)
            restartGame(inputBridge, trial)
    }

    private fun move(inputBridge: List<String>): List<String> {
        var inputBridge = inputBridge
        var whereToMove = InputView().readMoving()

        inputBridge = inputBridge.plus(whereToMove)
        inputBridge = checkOX(inputBridge)
        OutputView().printMap(inputBridge)

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

    private fun checkSuccess(inputBridge: List<String>): Boolean {
        var success = true
        inputBridge.forEachIndexed { index, it ->
            if (answerBridge[index] != it) {
                success = false
            }
        }
        return success
    }

    private fun restartGame(inputBridge: List<String>, trial: Int) {
        var inputRestartGame = InputView().readGameCommand()
        when (inputRestartGame) {
            "R" -> retry(answerBridge, trial)
            "Q" -> OutputView().printResult(inputBridge, false, trial)
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry(answerBridge: List<String>, trial: Int) {
        var trial = trial
        trial += 1
        moveAndCheckAnswer(trial)
    }
}
