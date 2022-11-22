package bridge

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(bridge: List<String>, root: List<String>) {
        val upBridge = getUpBridge(bridge, root)
        val downBridge = getDownBridge(bridge, root)

        println(upBridge)
        println(downBridge)
    }

    private fun getUpBridge(bridge: List<String>, root: List<String>): String {
        var result = "["
        for (i in root.indices) {
            result += getState(bridge[i], root[i], "U")
            result += if(i != root.size - 1) "|" else ""
        }
        result += "]"
        return result
    }

    private fun getDownBridge(bridge: List<String>, root: List<String>): String {
        var result = "]"
        for(i in root.indices) {
            result += getState(bridge[i], root[i], "D")
            result += if(i != root.size - 1) "|" else ""
        }
        result += "]"
        return result
    }

    private fun getState(bridgeState: String, rootState: String, position: String): String {
        if(bridgeState == position && bridgeState == rootState) {
            return " O "
        }
        if(bridgeState != position) {
            return "   "
        }
        return " X "
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(bridge: List<String>, root: List<String>): Boolean {
    }
}
