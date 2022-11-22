package bridge

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {


    fun printMap(bridge:Bridge){
        val roadUntilNow=bridge.getRoadUntilNow().getRoadMap()
        val upperSide=roadUntilNow[0].joinToString(" | ","[ "," ]")
        val lowerSide=roadUntilNow[1].joinToString(" | ","[ "," ]")

        println(upperSide+"\n"+lowerSide+"\n")
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult() {}
}
