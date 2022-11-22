package bridge

class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {
    fun makeBridge(size: Int): List<String> {
        val answerBridge = mutableListOf<String>()
        for (index in BRIDGE_START_INDEX until size) {
            val bridgeNumber = bridgeNumberGenerator.generate()
            if (bridgeNumber == DOWN_BRIDGE_NUMBER) answerBridge.add(ANSWER_DOWN)
            if (bridgeNumber == UP_BRIDGE_NUMBER) answerBridge.add(ANSWER_UP)
        }
        return answerBridge.toList()
    }

    fun makeCompletedBridge(answerBridge: List<String>, isUpBridge: Boolean): MutableList<String> {
        val bridge = mutableListOf<String>()
        for (answer in answerBridge) {
            when (answer) {
                ANSWER_UP -> if (isUpBridge) bridge.add(CORRECT_ANSWER) else bridge.add(SPACE)
                ANSWER_DOWN -> if (isUpBridge) bridge.add(SPACE) else bridge.add(CORRECT_ANSWER)
            }
        }
        return bridge
    }

    companion object {
        private const val BRIDGE_START_INDEX = 0
        private const val DOWN_BRIDGE_NUMBER = 0
        private const val UP_BRIDGE_NUMBER = 1
        private const val ANSWER_DOWN = "D"
        private const val ANSWER_UP = "U"
        private const val CORRECT_ANSWER = "O"
        private const val SPACE = " "
    }
}
