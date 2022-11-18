package bridge

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {
    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    fun makeBridge(size: Int): List<String> {
        //number가 0 , 1 일 때 U,D로 리스트 생성하기
        var answerBridge = listOf<String>()
        for (i in 1..size) {
            when (bridgeNumberGenerator.generate()) {
                0 -> {
                    answerBridge = answerBridge.plus("D")
                }
                1 -> {
                    answerBridge = answerBridge.plus("U")
                }
            }
        }
        return answerBridge
    }
}
