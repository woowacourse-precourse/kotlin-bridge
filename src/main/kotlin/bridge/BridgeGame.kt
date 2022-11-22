package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(private val bridge: List<String>) {

    var userMoving = Array(ROW_COUNT) { mutableListOf<String>() }

    var tryCount = 1
    var colPosition = 0
        private set

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(moving: String): Boolean {
        if (bridge[colPosition] == moving) {
            checkUserMoving(moving, "O")
            colPosition += 1
            return false
        }

        checkUserMoving(moving, "X")
        colPosition += 1
        return true
    }

    private fun checkUserMoving(moving: String, check: String) {
        val idx = when (moving) {
            "U" -> 0
            "D" -> 1
            else -> throw NoSuchElementException()
        }
        userMoving[idx].add(check)
        userMoving[(idx + 1) % 2].add(" ")
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {
        userMoving = Array(ROW_COUNT) { mutableListOf() }
        colPosition = 0
        tryCount += 1
    }

    companion object {
        private const val ROW_COUNT = 2
    }
}
