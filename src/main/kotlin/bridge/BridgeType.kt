package bridge

import bridge.constants.BridgePhrases.INCORRECT_BRIDGE_TYPE_NUMBER_CODE

enum class BridgeType(val numberCode: Int, val stringCode: String) {
    UP(1, "U"),
    DOWN(0, "D");

    companion object {
        fun convertNumberCodeToStringCode(numberCode: Int): String =
            BridgeType.values().find { it.numberCode == numberCode }?.stringCode ?: throw IllegalStateException(
                INCORRECT_BRIDGE_TYPE_NUMBER_CODE
            )
    }
}
