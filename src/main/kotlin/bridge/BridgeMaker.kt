package bridge

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {
    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    fun makeBridge(size: Int): List<String> =
        List(size) { bridgeNumberGenerator.generate() }.map {
            when (it) {
                0 -> "D"
                1 -> "U"
                else -> throw java.lang.IllegalStateException("[ERROR] 다리 값은 0 혹은 1이어야 합니다.")
            }
        }
}

