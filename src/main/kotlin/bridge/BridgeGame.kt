package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(private val bridge: List<String>) {
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     */
    var up = mutableListOf<String>()
    var down = mutableListOf<String>()
    var index = 0
    fun move(moving: String) {
        val isMovable = (moving == bridge[index])
        if (bridge[index++] == "U") {
            up.add(if (isMovable) " O " else "   ")
            down.add(if (isMovable) "   " else " X ")
        } else {
            up.add(if (isMovable) "   " else " X ")
            down.add(if (isMovable) " O " else "   ")
        }
    }

    /**
     * 게임의 진행상황을 결정하는 메서드 (실패/성공/진행)
     */
    fun isGameContinue(): String {
        if (up.last() == " X " || down.last() == " X ") return "FAIL"
        if (index == bridge.size) return "SUCCESS"
        return "CONTINUE"
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    fun retry() {}
}
