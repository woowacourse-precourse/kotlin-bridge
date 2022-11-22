package bridge.view

import bridge.BridgeType
import bridge.GameResult
import bridge.constants.BridgePhrases.BRIDGE_SIZE_PHRASE
import bridge.constants.BridgePhrases.FINAL_GAME_RESULT_ATTEMPT_NUMBER_PHRASE
import bridge.constants.BridgePhrases.FINAL_GAME_RESULT_PHRASE
import bridge.constants.BridgePhrases.FINAL_GAME_RESULT_SUCCESS_STATE_PHRASE
import bridge.constants.BridgePhrases.GAME_START_PHRASE
import bridge.constants.BridgePhrases.MOVING_BRIDGE_SELECT_PHRASE
import bridge.constants.BridgePhrases.RESTART_OR_QUIT_SELECT_PHRASE

class OutputView {

    fun printMap(bridgeCurrentState: Boolean, bridgeCurrentPosition: Int, Bridge: List<String>) {
        val dividedBridge = Bridge.subList(0, bridgeCurrentPosition)
        BridgeType.values().forEach {
            println(convertBridgeToString(convertToPrintingPurposeBridge(bridgeCurrentState, it, dividedBridge)))
        }
    }

    private fun convertBridgeToString(bridge: List<String>): String =
        bridge.joinToString(
            prefix = PRINTING_PURPOSE_BRIDGE_PREFIX,
            separator = PRINTING_PURPOSE_BRIDGE_SEPARATOR,
            postfix = PRINTING_PURPOSE_BRIDGE_POSTFIX
        )

    private fun convertToPrintingPurposeBridge(
        bridgeCurrentState: Boolean,
        bridgeType: BridgeType,
        dividedBridge: List<String>
    ): List<String> = convertLastElementToPrintingPurpose(
        bridgeCurrentState,
        convertElementToPrintingPurpose(bridgeType, dividedBridge)
    )

    private fun convertElementToPrintingPurpose(bridgeType: BridgeType, bridge: List<String>): List<String> {
        val processedBridge = bridge.toMutableList()
        processedBridge.replaceAll { if (it == bridgeType.stringCode) PRINTING_PURPOSE_BRIDGE_MOVABLE else PRINTING_PURPOSE_BRIDGE_NOT_SELECTED }
        return processedBridge
    }

    private fun convertLastElementToPrintingPurpose(bridgeCurrentState: Boolean, bridge: List<String>): List<String> {
        val processedBridge = bridge.toMutableList()
        if (!bridgeCurrentState) {
            if (processedBridge.last() == PRINTING_PURPOSE_BRIDGE_NOT_SELECTED) processedBridge[processedBridge.lastIndex] =
                PRINTING_PURPOSE_BRIDGE_IMMOVABLE
            if (processedBridge.last() == PRINTING_PURPOSE_BRIDGE_MOVABLE) processedBridge[processedBridge.lastIndex] =
                PRINTING_PURPOSE_BRIDGE_NOT_SELECTED
        }
        return processedBridge
    }

    fun printResult(gameResult: GameResult, attemptNumber: Int) {
        println(FINAL_GAME_RESULT_SUCCESS_STATE_PHRASE + gameResult.stringCode)
        println(FINAL_GAME_RESULT_ATTEMPT_NUMBER_PHRASE + attemptNumber.toString())
    }

    fun printGameStartPhrase() {
        println(GAME_START_PHRASE)
    }

    fun printBridgeSizePhrase() {
        println(BRIDGE_SIZE_PHRASE)
    }

    fun printMovingBridgeSelectPhrase() {
        println(MOVING_BRIDGE_SELECT_PHRASE)
    }

    fun printRestartOrQuitSelectPhrase() {
        println(RESTART_OR_QUIT_SELECT_PHRASE)
    }

    fun printFinalGamsResultPhrase() {
        println(FINAL_GAME_RESULT_PHRASE)
    }

    companion object {
        private const val PRINTING_PURPOSE_BRIDGE_PREFIX = "["
        private const val PRINTING_PURPOSE_BRIDGE_POSTFIX = "]"
        private const val PRINTING_PURPOSE_BRIDGE_SEPARATOR = "|"
        private const val PRINTING_PURPOSE_BRIDGE_MOVABLE = " O "
        private const val PRINTING_PURPOSE_BRIDGE_IMMOVABLE = " X "
        private const val PRINTING_PURPOSE_BRIDGE_NOT_SELECTED = "   "
    }
}
