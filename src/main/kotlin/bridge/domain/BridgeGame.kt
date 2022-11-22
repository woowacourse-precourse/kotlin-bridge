package bridge.domain


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
    fun move(line: MutableList<String>, moving: String, answer: String) {
        line.add(getSymbol(moving, answer))
    }

    fun getSymbol(moving: String, answer: String): String {
        if (judgeCorrect(moving, answer)) {
            return "O"
        }
        return "X"
    }

    fun judgeCorrect(moving: String, answer: String): Boolean {
        if (moving == answer) {
            return true
        }
        return false
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry(command: String): Boolean {
        if (command == "R") {
            return true
        }
        return false
    }


}
