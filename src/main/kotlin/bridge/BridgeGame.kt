package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {
    var upResult: MutableList<String> = mutableListOf()
    var downResult: MutableList<String> = mutableListOf()

    enum class CommendKey(val letter: String) {
        UP("U"),
        DOWN("D"),
        RESTART("R"),
        Quit("Q")
    }

    enum class BridgeSquare(val mark: String) {
        CORRECT(" O "),
        INCORRECT(" X "),
        SPACE("   ")
    }

    fun move(direction: String, square: String): Boolean {
        if (square == direction) {
            markCorrectAnswer(direction)
            return true
        }
        markIncorrectAnswer(direction)
        return false
    }

    fun markCorrectAnswer(direction: String) {
        if (direction == CommendKey.UP.letter) {
            upResult.add(BridgeSquare.CORRECT.mark)
            downResult.add(BridgeSquare.SPACE.mark)
        }
        if (direction == CommendKey.DOWN.letter) {
            upResult.add(BridgeSquare.SPACE.mark)
            downResult.add(BridgeSquare.CORRECT.mark)
        }
    }

    fun markIncorrectAnswer(direction: String) {
        if (direction == CommendKey.UP.letter) {
            upResult.add(BridgeSquare.INCORRECT.mark)
            downResult.add(BridgeSquare.SPACE.mark)
        }
        if (direction == CommendKey.DOWN.letter) {
            upResult.add(BridgeSquare.SPACE.mark)
            downResult.add(BridgeSquare.INCORRECT.mark)
        }
    }

    fun retry(restartOrNot: String): Boolean {
        if (restartOrNot == CommendKey.RESTART.letter) {
            return true
        }
        return false
    }
}
