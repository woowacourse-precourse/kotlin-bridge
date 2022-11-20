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
        val bridge = mutableListOf<String>()
        for(i in 0 until size) {
            when(bridgeNumberGenerator.generate()) {
                0 -> bridge.add("D")
                1 -> bridge.add("U")
            }
        }
        return bridge
    }
}

/**
 * 주의 사항(지울 것)
 * 필드를 변경하면 안 된다.
 * 메서드의 시그니처(인자, 이름)와 변환 타입은 변경할 수 없다.
 */