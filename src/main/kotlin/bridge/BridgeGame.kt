package bridge

class BridgeGame {
    private val upMap = mutableMapOf<String, List<String>>()
    private val downMap = mutableMapOf<String, List<String>>()

    fun move(space: String, bridge: List<String>): Map<String, List<String>> {
        if (space == bridge[index]) {
            checkSpace(space, "O")
            index += 1
        } else if ((space != bridge[index])) {
            checkSpace(space, "X")
        }
        return upMap + downMap
    }

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

    fun transformedList(position: List<String>): String {
        return position.joinToString(" | ", "[ ", " ]")
    }

    private fun checkSpace(space: String, ox: String) {
        if (space == UP) {
            addToList(ox, BLANK)
        } else if (space == DOWN) {
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
