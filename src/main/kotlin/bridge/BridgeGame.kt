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
    private val upMap = mutableMapOf<String, List<String>>()
    private val downMap = mutableMapOf<String, List<String>>()

    fun move(space: String, bridge: List<String>): Map<String, List<String>> {
        if (space == bridge[index]) {
            checkSpace(space, "O")
            index += 1
        } else {
            checkSpace(space, "X")
        }
        return upMap + downMap
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

        upMap.clear()
        downMap.clear()
    }

    fun separateList(movingList: Map<String, List<String>>, position: String): List<String> {
        return movingList.filter { it.key == position }.values.flatten()
    }

    private fun checkSpace(space: String, ox: String) {
        if (space == UP) {
            addToList(ox, BLANK)
        } else {
            addToList(BLANK, ox)
        }
    }

    private fun addToList(up: String, down: String) {
        upList.add(up)
        downList.add(down)
        upMap[UP] = upList
        downMap[DOWN] = downList
    }

    companion object {
        const val UP = "U"
        const val DOWN = "D"
        const val BLANK = " "

        private var index = 0
        private val upList = mutableListOf<String>()
        private val downList = mutableListOf<String>()

        fun getUpList() = upList

        fun getDownList() = downList

        fun successConditions(bridge: List<String>) = index == bridge.size

        fun failureConditions() = upList.contains("X") || downList.contains("X")
    }
}
