package bridge.io

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     */
    fun printMap(topRow:List<String>,BotRow:List<String>) {
        printLine(topRow)
        printLine(BotRow)
    }
    private fun printLine(line:List<String>){ // 한줄 출력
        println("[ "+line.joinToString(" | ")+" ]")
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     */
    fun printResultTitle() {
        println("최종 게임 결과")
    }
    fun printResultStatus(result:String,tryCount:Int){
        println("게임 성공 여부: $result")
        println("총 시도한 횟수: $tryCount")
    }
}
