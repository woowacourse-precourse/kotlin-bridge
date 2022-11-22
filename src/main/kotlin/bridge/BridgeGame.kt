package bridge

import view.InputView
import view.OutputView

/**
 * 다리 건너기 게임을 관리하는 클래스
BridgeGame에 필드를 추가할 수 있다.
BridgeGame의 패키지는 변경할 수 있다.
BridgeGame의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
게임 진행을 위해 필요한 메서드를 추가하거나 변경 할 수 있다.
BridgeGame 클래스에서 InputView, OutputView 를 사용하지 않는다.
 */
class BridgeGame {
    fun startGame(bridgeSize: Int, bridgeLetter: List<String>): Boolean{
        val resultBridge: MutableList<Pair<String, String>> = mutableListOf()
        for(i in 0 until bridgeSize){
            val moveLetter = InputView().readMoving()
            val result = move(bridgeLetter[i], moveLetter)
            resultBridge.add(Pair(moveLetter, result))
            OutputView().printMap(resultBridge)
            if(result == "X"){
                return retry()
            }
        }
        OutputView().printResult(resultBridge)
        return false
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private fun move(bridgeLetter: String, moveLetter: String): String {
        var result = " "
        if (bridgeLetter != moveLetter) {
            result = "X"
            return result
        }
        result = "O"
        return result
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private fun retry(): Boolean {
        val userInput = InputView().readGameCommand()
        return userInput == "R"
    }
}
