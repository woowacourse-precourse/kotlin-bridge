package bridge.view

import bridge.BridgeType
import bridge.constants.BridgePhrases.BRIDGE_SIZE_PHRASE
import bridge.constants.BridgePhrases.GAME_START_PHRASE
import bridge.constants.BridgePhrases.MOVING_BRIDGE_SELECT_PHRASE
import bridge.constants.BridgePhrases.RESTART_OR_QUIT_SELECT_PHRASE

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(bridgeCurrentState: Boolean, bridgeCurrentPosition: Int, Bridge: List<String>) {
    }

    private fun convertToPrintingPurposeBridge(
        bridgeCurrentState: Boolean,
        bridgeType: BridgeType,
        dividedBridge: List<String>
    ): List<String> = convertPrintingPurposeBridgeLastElement(
        bridgeCurrentState,
        convertElementToPrintingPurpose(bridgeType, dividedBridge)
    )

    private fun convertElementToPrintingPurpose(bridgeType: BridgeType, dividedBridge: List<String>): List<String> {
        val dividedBridge = dividedBridge.toMutableList()
        dividedBridge.replaceAll { if (it == bridgeType.stringCode) PRINTING_PURPOSE_BRIDGE_MOVABLE else PRINTING_PURPOSE_BRIDGE_NOT_SELECTED }
        return dividedBridge
    }

    private fun convertPrintingPurposeBridgeLastElement(
        bridgeCurrentState: Boolean,
        processedDividedBridge: List<String>
    ): List<String> {
        val processedDividedBridge = processedDividedBridge.toMutableList()
        if (!bridgeCurrentState) {
            if (processedDividedBridge.last() == PRINTING_PURPOSE_BRIDGE_NOT_SELECTED) processedDividedBridge[processedDividedBridge.lastIndex] =
                PRINTING_PURPOSE_BRIDGE_IMMOVABLE
            if (processedDividedBridge.last() == PRINTING_PURPOSE_BRIDGE_MOVABLE) processedDividedBridge[processedDividedBridge.lastIndex] =
                PRINTING_PURPOSE_BRIDGE_NOT_SELECTED
        }
        return processedDividedBridge
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult() {}

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

    companion object {
        private const val PRINTING_PURPOSE_BRIDGE_PREFIX = "["
        private const val PRINTING_PURPOSE_BRIDGE_POSTFIX = "]"
        private const val PRINTING_PURPOSE_BRIDGE_SEPARATOR = "|"
        private const val PRINTING_PURPOSE_BRIDGE_MOVABLE = " O "
        private const val PRINTING_PURPOSE_BRIDGE_IMMOVABLE = " X "
        private const val PRINTING_PURPOSE_BRIDGE_NOT_SELECTED = "   "
    }
}
