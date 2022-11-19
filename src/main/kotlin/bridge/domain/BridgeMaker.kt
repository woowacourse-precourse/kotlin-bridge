package bridge.domain

import bridge.BridgeNumberGenerator

enum class UpDown(val number: Int, val space: String) {
    UP(1, "U"),
    DOWN(0, "D");
}

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
        repeat(size) {
            when (bridgeNumberGenerator.generate()) {
                UpDown.UP.number -> bridge.add(UpDown.UP.space)
                UpDown.DOWN.number -> bridge.add(UpDown.DOWN.space)
            }
        }
        return bridge.toList()
    }
}
