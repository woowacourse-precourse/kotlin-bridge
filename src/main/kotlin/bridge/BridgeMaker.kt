package bridge

import bridge.view.InputView

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {
    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    fun makeBridge(size: Int): List<String> {
        var bridge = ArrayList<String>()

        repeat(size) {
            var direction = changeNum(bridgeNumberGenerator.generate().toString())
            direction?.let { direction -> bridge.add(direction) }
        }

        return bridge
    }

    fun changeNum(num: String): String? {
        if (num == "0") return "D"
        if (num == "1") return "U"

        return null
    }

    fun printSize(): String {
        try {
            val size = InputView().readBridgeSize()
            CheckException().checkInputSize(size)
            return size
        } catch (e: IllegalArgumentException) {
            println(e)
            println("\n")
            val size = printSize()
            return size
        }
    }
}
