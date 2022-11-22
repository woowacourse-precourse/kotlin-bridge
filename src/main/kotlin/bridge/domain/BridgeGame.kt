package bridge.domain

import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator
import bridge.data.*

class BridgeGame {
    private val bridgeRandomNumberGenerator = BridgeRandomNumberGenerator()
    private val bridgeMaker = BridgeMaker(bridgeRandomNumberGenerator)
    private val upperBridge = mutableListOf<String>()
    private val lowerBridge = mutableListOf<String>()
    private var coin = ONE

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

    fun retry() {
        upperBridge.clear()
        lowerBridge.clear()
        coin++
    }

    fun getCoin(): Int {
        return coin
    }

    fun getUpperBridge(): String {
        return upperBridge
            .joinToString(prefix = LEFT_LADDER, separator = CENTER_LADDER, postfix = RIGHT_LADDER)
    }

    fun getLowerBridge(): String {
        return lowerBridge
            .joinToString(prefix = LEFT_LADDER, separator = CENTER_LADDER, postfix = RIGHT_LADDER + NEXT_LINE)
    }

    fun makeBridge(size: Int): List<String> {
        return bridgeMaker.makeBridge(size)
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
