package bridge

import bridge.exception.PrintException
import bridge.view.OutputView

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(val answerBridge : List<String>) {

    var upBridge = ArrayList<String>()
    var downBridge = ArrayList<String>()
    var inputBridge = ArrayList<String>()
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(direction : String) {
        inputBridge.add(direction)
        if (direction == answerBridge[inputBridge.size-1]) {
            updateBridge(direction, "O")
        }
        if (direction != answerBridge[inputBridge.size-1]) {
            updateBridge(direction, "X")
        }
    }

   fun updateBridge(direction: String, answer: String) {
        if (direction == "U") {
            upBridge.add(answer)
            downBridge.add(" ")
        }
        if (direction == "D") {
            upBridge.add(" ")
            downBridge.add(answer)
        }
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
//    fun retry(answer: String ) {
//        val restart = OutputView().restartGame(answer)
//
//        if(restart == "Q"){
//
//
//        }
//    }




}
