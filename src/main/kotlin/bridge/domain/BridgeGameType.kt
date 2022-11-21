package bridge.domain

import bridge.BridgeRandomNumberGenerator.Companion.RANDOM_LOWER_INCLUSIVE
import bridge.BridgeRandomNumberGenerator.Companion.RANDOM_UPPER_INCLUSIVE
import bridge.resources.ERROR_INPUT_COMMAND
import bridge.resources.ERROR_INPUT_VALID

enum class BridgeGameType(val type: String, val inclusive: Int) {
    UP("U", RANDOM_UPPER_INCLUSIVE),
    DOWN("D", RANDOM_LOWER_INCLUSIVE);

    companion object {
        fun of(inclusive: Int): BridgeGameType {
            return BridgeGameType.values().find { it.inclusive == inclusive }
                ?: throw IllegalArgumentException(ERROR_INPUT_VALID)
        }
        fun getTypeList(): List<String> {
            return BridgeGameType.values().map { it.type }
        }
    }
}
