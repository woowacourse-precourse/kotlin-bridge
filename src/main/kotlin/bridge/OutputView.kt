package bridge

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    val bridgeStatus = mutableListOf<Pair<String, String>>()
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap() {
        printUpperBridge()
        printDownBridge()
    }

    fun printBridge(userBridge: List<String>, bool: Boolean){
        when(Pair(userBridge[userBridge.lastIndex], bool)){
            Pair("U", true) -> bridgeStatus.add(Pair("O", " "))
            Pair("D", true) -> bridgeStatus.add(Pair(" ", "O"))
            Pair("U", false) -> bridgeStatus.add(Pair("X", " "))
            Pair("D", false) -> bridgeStatus.add(Pair(" ", "X"))
        }
    }

    fun printClearBridge() {
        bridgeStatus.clear()
    }

    fun printUpperBridge() {
        val strBridge = bridgeStatus.map{it.first}.joinToString(
            prefix = "[ ",
            separator = " | ",
            postfix = " ]",
            transform = String::toString
        )
        return println(strBridge)
    }

    fun printDownBridge(){
        val strBridge = bridgeStatus.map{it.second}.joinToString(
            prefix = "[ ",
            separator = " | ",
            postfix = " ]",
            transform = String::toString
        )
        return println(strBridge)
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(bool: Boolean, count: Int) {
        println()
        when(bool){
            true -> println("게임 성공 여부: 성공")
            false -> println("게임 성공 여부: 실패")
        }
        println("총 시도한 횟수: $count")
    }
    fun printResult(){
        println("\n최종 게임 결과")
        printMap()
    }

    /** <출력> 다리 건너기 게임을 시작합니다. */
    fun printGameStart() {
        println("다리 건너기 게임을 시작합니다.\n")
    }

    /** <출력> 다리의 길이를 입력해주세요. */
    fun printBridgeLength() {
        println("다리의 길이를 입력해주세요.")
    }

    /** <출력> 이동할 칸을 선택해주세요. (위: U, 아래: D) */
    fun printSelectMoveToSpace() {
        println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)")
    }

    /** <출력> 게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q) */
    fun printSelectRetry() {
        println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
    }
}
