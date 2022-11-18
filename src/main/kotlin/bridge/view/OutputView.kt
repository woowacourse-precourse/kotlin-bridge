package bridge.view

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(currentMap: List<String>, isSuccess: Boolean) {
        println(getUpBridgeForm(currentMap, isSuccess))
        println(getDownBridgeForm(currentMap, isSuccess))
    }

    private fun getUpBridgeForm(currentMap: List<String>, isSuccess: Boolean): String {
        var result = "[ ${getUpValue(currentMap[0], isSuccess)}"
        for (count in 1 until currentMap.size) {
            result = result + " | " + getUpValue(currentMap[count], isSuccess)
        }
        result += " ]"
        return result
    }

    private fun getUpValue(bridgeLastValue: String, isSuccess: Boolean): String {
        var result = ""
        if (bridgeLastValue == "D") result = " "
        else if (bridgeLastValue == "U" && isSuccess) result = "O"
        else if (bridgeLastValue == "U" && !isSuccess) result = "X"
        return result
    }

    private fun getDownBridgeForm(currentMap: List<String>, isSuccess: Boolean): String {
        var result = "[ ${getDownValue(currentMap[0], isSuccess)}"
        for (count in 1 until currentMap.size) {
            result = result + " | " + getDownValue(currentMap[count], isSuccess)
        }
        result += " ]"
        return result
    }

    private fun getDownValue(bridgeLastValue: String, isSuccess: Boolean): String {
        var result = ""
        if (bridgeLastValue == "U") result = " "
        else if (bridgeLastValue == "D" && isSuccess) result = "O"
        else if (bridgeLastValue == "D" && !isSuccess) result = "X"
        return result
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult() {}
}
