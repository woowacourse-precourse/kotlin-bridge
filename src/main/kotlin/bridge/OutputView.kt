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

    private val bridgeUpperSide = mutableListOf<String>()
    private val bridgeDownSide = mutableListOf<String>()
    private var gameFailed = 0

    fun bridgeCaseUO() {
        bridgeUpperSide.add( " O ")
        bridgeDownSide.add("   ")
    }
    fun bridgeCaseDO() {
        bridgeUpperSide.add( "   ")
        bridgeDownSide.add(" O ")
    }
    fun bridgeCaseUX() {
        bridgeUpperSide.add( " X ")
        bridgeDownSide.add("   ")
        gameFailed = 1
    }
    fun bridgeCaseDX() {
        bridgeUpperSide.add( "   ")
        bridgeDownSide.add(" X ")
        gameFailed = 1
    }

    fun printMap(bridgeAnswer: List<String>, moveResult : List<String>): Int {
        for (count in moveResult.indices){
            if (bridgeAnswer[count] =="U" && moveResult[count]=="O") bridgeCaseUO()
            if (bridgeAnswer[count] =="U" && moveResult[count]=="O") bridgeCaseDO()
            if (bridgeAnswer[count] =="U" && moveResult[count]=="X"){ bridgeCaseUX()
                break }
            if (bridgeAnswer[count] =="D" && moveResult[count]=="X") { bridgeCaseDX()
                break }
        }
        println("["+(bridgeUpperSide.toString().replace(",","|"))+"]")
        println("["+(bridgeDownSide.toString().replace(",","|"))+"]\n")
        return gameFailed
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(bridgeAnswer: List<String>, gameCommand : String, retryCount : Int) {
        print("게임 성공 여부: ")
        when (gameCommand){
            "R" -> println("성공")
            "Q" -> println("실패")
        }
        print("총 시도한 횟수: $retryCount")
    }
}
