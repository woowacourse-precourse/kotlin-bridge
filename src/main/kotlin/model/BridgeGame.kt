package model

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
    fun move(inputMove : String, answerMoveSingle: String) : HashMap<String, String> {
        val hashMap = HashMap<String, String>()
        if (inputMove == "U") {
            if (inputMove == answerMoveSingle) {
                hashMap["U"] = "O"
                return hashMap
            }
            hashMap["U"] = "X"
            return hashMap
        } else if (inputMove == "D") {
            if (inputMove == answerMoveSingle) {
                hashMap["D"] = "O"
                return hashMap
            }
            hashMap["D"] = "X"
            return hashMap
        }
        return hashMap
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() : Boolean {
        // 게임을 다시 시도할지 여부를 입력해주세요.
        view.OutputView().printAskGameResult()
        val inputGameRestartCommand = view.InputView().readGameCommand()
        if (inputGameRestartCommand == "R") {
            return true
        }
        // 예외 처리 해야함.
        return false
    }
}
