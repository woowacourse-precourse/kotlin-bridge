package bridge.view
import bridge.model.Bridge
import bridge.utils.Constants.SUCCESS_SYMBOL
import bridge.utils.Constants.FAIL_SYMBOL
import bridge.utils.Constants

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView() {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(upLane: List<String>, downLane: List<String>) {
        printUpLane(upLane)
        printDownLane(downLane)
    }

    fun printUpLane(upLane: List<String>){
        var upLaneShape = ""
        for (index in upLane.indices){
            upLaneShape += upLane[index]
            if (index != upLane.size - 1)
                upLaneShape += "|"
        }
        println(listOf(upLaneShape))
    }

    fun printDownLane(downLane: List<String>){
        var downLaneShape = ""
        for (index in downLane.indices){
            downLaneShape += downLane[index]
            if (index != downLane.size - 1)
                downLaneShape += "|"
        }
        println(listOf(downLaneShape))
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult() {}
    
}
