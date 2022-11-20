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

        // 0, 1로 이루어진 답지 만들기
        val answerAnswer = mutableListOf<String>()

        // 일단 0으로만 이루어진 다리 만들기
        for (eachBridge in 0 until size*2-1) {
            answerAnswer.add("0")
        }

        // randomNumber generator을 통해 최종 정답 다리 만들기
        // 초반 size개는 길 윗칸, 이후 size개는 길 아랫칸
        for (eachBridge in 0 until size*2-1) {
            answerAnswer[eachBridge] = bridgeNumberGenerator.generate().toString()
        }

        return answerAnswer
    }
}
