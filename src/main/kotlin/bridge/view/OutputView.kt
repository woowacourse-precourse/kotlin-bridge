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
        var result = "[ ${getUpValue(currentMap[0], isSuccess,currentMap.lastIndex==0)}"
        for (count in 1 until currentMap.size) {
            result = result + " | " + getUpValue(currentMap[count], isSuccess,count==currentMap.lastIndex)
        }
        result += " ]"
        return result
    }

    private fun getUpValue(bridgeValue: String, isSuccess: Boolean, isLastValue : Boolean): String {
        var result = ""
        if (bridgeValue == "D") result = " "
        else if (bridgeValue == "U" && !isSuccess && isLastValue) result = "X"
        else if (bridgeValue == "U") result = "O"
        return result
    }

    private fun getDownBridgeForm(currentMap: List<String>, isSuccess: Boolean): String {
        var result = "[ ${getDownValue(currentMap[0], isSuccess,currentMap.lastIndex==0)}"
        for (count in 1 until currentMap.size) {
            result = result + " | " + getDownValue(currentMap[count], isSuccess,count==currentMap.lastIndex)
        }
        result += " ]"
        return result
    }

    private fun getDownValue(bridgeValue: String, isSuccess: Boolean, isLastValue : Boolean): String {
        var result = ""
        if (bridgeValue == "U") result = " "
        else if (bridgeValue == "D" && !isSuccess && isLastValue) result = "X"
        else if (bridgeValue == "D") result = "O"
        return result
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(currentMap: List<String>, isSuccess: Boolean, tryCount : Int) {
        println("최종 게임 결과")
        printMap(currentMap,isSuccess)
        outputGameResult(isSuccess)
        outputResultTryCount(tryCount)
    }

    private fun outputGameResult(isGameWin : Boolean){
        if(isGameWin) println("게임 성공 여부: 성공") else println("게임 성공 여부: 실패")
    }

    private fun outputResultTryCount(tryCount: Int){
        println("총 시도한 횟수: $tryCount")
    }
}
