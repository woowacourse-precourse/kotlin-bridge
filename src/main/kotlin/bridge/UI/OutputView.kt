package bridge.UI

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(upSelectedBridge : List<String>, downSelectedBridge : List<String>) {
        println(upSelectedBridge.joinToString(prefix = BRIDGE_PREFIX, separator = BRIDGE_SEPARATOR, postfix = BRIDGE_POSTFIX))
        println(downSelectedBridge.joinToString(prefix = BRIDGE_PREFIX, separator = BRIDGE_SEPARATOR, postfix = BRIDGE_POSTFIX))
        println()
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
//    fun printResult(upSelectedBridge : List<String>, downSelectedBridge : List<String>) {
//        println("최종 게임 결과")
//        printMap(upSelectedBridge, downSelectedBridge)
//        print("게임 성공 여부: ")
//        print("총 시도한 횟수: ")
//    }

    fun printStartLog(){
        println("다리 건너기 게임을 시작합니다.\n")
    }

    fun printGetBridgeLengthLog(){
        println("다리의 길이를 입력해주세요.")
    }

    companion object{
        const val BRIDGE_PREFIX = "[ "
        const val BRIDGE_POSTFIX = " ]"
        const val BRIDGE_SEPARATOR = " | "
    }

}
