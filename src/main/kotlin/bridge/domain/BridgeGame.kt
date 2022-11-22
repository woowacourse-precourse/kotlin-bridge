package bridge.domain

class BridgeGame {
    fun move(moving: String, answer: String): String {
        return getSymbol(moving, answer)
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

    fun retry(command: String): Boolean {
        if (command == "R") {
            return true
        }
        return false
    }
}
