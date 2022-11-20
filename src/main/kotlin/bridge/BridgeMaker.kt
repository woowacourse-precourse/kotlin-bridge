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
        val row = size
        val column = 2
        // 0, 1로 이루어진 답지 만들기
        val answer = Array(size, {IntArray(2, {0})})

        for (c in 0 until column-1) {
            for (r in 0 until row-1) {
                answer[c][r] = bridgeNumberGenerator.generate()
            }
        }



        return listOf()
    }
}
