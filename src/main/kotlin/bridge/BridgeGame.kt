package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(private val bridges: List<String>) {
    private val upSide = mutableListOf<String>()
    private val downSide = mutableListOf<String>()
    private var currentPosition = 0

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(direction: String) {
        if (direction == bridges[currentPosition]) {
            addSide(direction, "O")
        } else {
            addSide(direction, "X")
        }
        currentPosition++
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {
        currentPosition = 0
        upSide.clear()
        downSide.clear()
    }

    private fun addSide(side: String, state: String) {
        when (side) {
            "D" -> {
                upSide.add(" ")
                downSide.add(state)
            }

            "U" -> {
                upSide.add(state)
                downSide.add(" ")
            }
        }
    }

    fun checkFail() = downSide.contains("X") || upSide.contains("X")

    fun checkEnd() = currentPosition == bridges.size
}
