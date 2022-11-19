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
    private val up = mutableMapOf<String, List<String>>()
    private val down = mutableMapOf<String, List<String>>()

    fun move(space: String, bridge: List<String>): Map<String, List<String>> {
        if (space == bridge[index]) {
            addToList(space, "O")
            index += 1
        } else {
            addToList(space, "X")
        }
        return up + down
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {
        index = 0

        upList.clear()
        downList.clear()

        up.clear()
        down.clear()
    }

    private fun addToList(space: String, ox: String) {
        if (space == "U") {
            upList.add(ox)
            downList.add(" ")
            up[space] = upList
        } else if (space == "D") {
            upList.add(" ")
            downList.add(ox)
            down[space] = downList
        }
    }

    companion object {
        private var index = 0
        private val upList = mutableListOf<String>()
        private val downList = mutableListOf<String>()

        fun getUpList() = upList

        fun getDownList() = downList

        fun success(bridge: List<String>) = index == bridge.size

        fun failure() = upList.contains("X") || downList.contains("X")
    }
}
