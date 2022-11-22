package bridge.domain

import bridge.data.*

class BridgeGame {
    private val bridgeRandomNumberGenerator = BridgeRandomNumberGenerator()
    private val bridgeMaker = BridgeMaker(bridgeRandomNumberGenerator)
    private val upperBridge = mutableListOf<String>()
    private val lowerBridge = mutableListOf<String>()
    private var coin = 1

    fun move(bridge: List<String>, upAndDown: String, level: Int): Boolean {
        when (verify(bridge, upAndDown, level)) {
            true -> pushCorrect(upAndDown)
            false -> {
                pushIncorrect(upAndDown)
                return false
            }
        }
        return true
    }

    private fun verify(bridge: List<String>, upAndDown: String, level: Int): Boolean {
        return bridge[level] == upAndDown
    }

    private fun pushCorrect(upAndDown: String) {
        if (upAndDown == UP) {
            upperBridge.add(CORRECT)
            lowerBridge.add(BLANK)
        }

        if (upAndDown == DOWN) {
            upperBridge.add(BLANK)
            lowerBridge.add(CORRECT)
        }
    }

    private fun pushIncorrect(upAndDown: String) {
        if (upAndDown == UP) {
            upperBridge.add(INCORRECT)
            lowerBridge.add(BLANK)
        }

        if (upAndDown == DOWN) {
            upperBridge.add(BLANK)
            lowerBridge.add(INCORRECT)
        }
    }

}
