package view

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {

    private val MESSAGE_START = "다리 건너기 게임을 시작합니다.\n"
    private val MESSAGE_BRIDGE_SIZE = "다리의 길이를 입력해주세요."
    private val MESSAGE_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
    private val MESSAGE_SUCCESS_OR_FAILURE = "게임 성공 여부:"
    private val MESSAGE_TOTAL_TRY = "총 시도한 횟수:"
    private val MESSAGE_RESULT_MAP = "최종 게임 결과"
    val MESSAGE_READ_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)"

    private val MESSAGE_FRONT_BRACKET = "["
    private val MESSAGE_BACK_BRACKET = "]"

    private val inputView = InputView()

    fun printStart():String{
        return MESSAGE_START
    }

    fun printBridgeSize():String{
        return MESSAGE_BRIDGE_SIZE
    }

    fun printMoving(): String{
        println(MESSAGE_READ_MOVING)
        val move = inputView.readMoving()
        println(move)
        return move
    }

    fun printRetry(): String {
        println(MESSAGE_RETRY)
        return inputView.readGameCommand()
    }


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(bridgeToNow: Int, bridge: List<String>, nowMove:String): Pair<List<String>,List<String>> {
        val bridgeTopMap = mutableListOf<String>()
        val bridgeDownMap = mutableListOf<String>()
        bridgeTopMap.add(MESSAGE_FRONT_BRACKET)
        bridgeDownMap.add(MESSAGE_FRONT_BRACKET)
        for (i in 0 until bridgeToNow){
            if (bridgeToNow-1 == i && bridge[i] != nowMove){
                if (bridge[i]=="U") {
                    bridgeTopMap.add(" ")
                    bridgeDownMap.add("X")
                }
                if (bridge[i]=="D") {
                    bridgeTopMap.add("X")
                    bridgeDownMap.add(" ")
                }
            }else{
                if (bridge[i]=="U") {
                    bridgeTopMap.add("O")
                    bridgeDownMap.add(" ")
                }
                if (bridge[i]=="D") {
                    bridgeTopMap.add(" ")
                    bridgeDownMap.add("O")
                }
                if (i != bridgeToNow-1) {
                    bridgeTopMap.add("|")
                    bridgeDownMap.add("|")
                }
            }
        }
        bridgeTopMap.add(MESSAGE_BACK_BRACKET)
        bridgeDownMap.add(MESSAGE_BACK_BRACKET)

        println(bridgeTopMap.joinToString(" "))
        println("${bridgeDownMap.joinToString(" ")}\n")
        return Pair(bridgeTopMap, bridgeDownMap)
    }

    // 최종 결과 맵 출력
    fun printResultMap(bridgeMap: Pair<List<String>,List<String>>){
        println(MESSAGE_RESULT_MAP)
        println(bridgeMap.first.joinToString(" "))
        println("${bridgeMap.second.joinToString(" ")}\n")
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(successOrFailure: String, totalTry:Int) {
        println("$MESSAGE_SUCCESS_OR_FAILURE $successOrFailure")
        println("$MESSAGE_TOTAL_TRY $totalTry")
    }
}
