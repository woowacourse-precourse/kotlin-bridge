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
    fun move(answerBridge: List<String>, trial: Int) {
        var inputBridge = listOf<String>()
        var success = true

        while (success) {
            var whereToMove = InputView().readMoving()

            inputBridge = inputBridge.plus(whereToMove)
            var inputBridgeMutable = inputBridge.toMutableList()

            inputBridge.forEachIndexed { index, it ->
                if (answerBridge[index] != it) {
                    success = false
                    inputBridgeMutable[index] = it + "X"
                    inputBridge = inputBridgeMutable.toList()
                }
            }

            var outputView = OutputView()
            outputView.printMap(inputBridge)

            if (!success) {
                var restartGame = InputView().readGameCommand()
                when (restartGame) {
                    "R" -> BridgeGame().retry(answerBridge, trial)
                    "Q" -> OutputView().printResult()
                }
            }
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
        move(answerBridge, trial)
    }
}
