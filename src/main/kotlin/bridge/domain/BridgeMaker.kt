package bridge.domain

import bridge.BridgeNumberGenerator

class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {
    fun makeBridge(size: Int): List<String> {
        val bridge = mutableListOf<String>()
        for (index in 1..size) {
            val bridgeNumber = bridgeNumberGenerator.generate()
            if (bridgeNumber == 0) bridge.add("D")
            if (bridgeNumber == 1) bridge.add("U")
        }
        return bridge.toList()
    }

    fun makeCompletedBridge(answerBridge: List<String>, isUpBridge: Boolean): MutableList<String> {
        val bridge = mutableListOf<String>()
        for (answer in answerBridge) {
            when (answer) {
                "U" -> if (isUpBridge) bridge.add("O") else bridge.add(" ")
                "D" -> if (isUpBridge) bridge.add(" ") else bridge.add("O")
            }
        }
        return bridge
    }
}
