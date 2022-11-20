package bridge

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 * 요구사항 ⬇
 * 제공된 BridgeMaker 클래스를 활용해 구현해야 한다.
 * BridgeMaker의 필드를 변경할 수 없다.
 * BridgeMaker의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 없다.
 */
class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {
    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    fun makeBridge(size: Int): List<String> {
        val bridge = mutableListOf<String>()
        for (index in 1..size) {
            val bridgeNumber = bridgeNumberGenerator.generate()
            if (bridgeNumber == 0) bridge.add("D")
            if (bridgeNumber == 1) bridge.add("U")
        }
        return bridge.toList()
    }
}
