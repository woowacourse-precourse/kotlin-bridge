package bridge

import bridge.strings.BridgeGameErrorMessages
import bridge.strings.BridgeGameMessages

class BridgeChecker(
    private val size: Int,
    private val bridgeMaker: BridgeMaker,
) {
    private val bridgeInFog = bridgeMaker.makeBridge(size)
    private var bridgeRevealed = mutableListOf<List<String>>()

    fun toVisualizationOpenedPart(): String {
        val sb: StringBuilder = StringBuilder().also {
            it.append(makeLine(0)).append("\n")
            it.append(makeLine(1))
        }
        return sb.toString()
    }

    fun toVisualizationGameResult(): String {
        return BridgeGameMessages.makeFinalMessage(
            toVisualizationOpenedPart(), isSuccess(), bridgeRevealed.size
        )
    }

    fun checkWithUpdating(ans: String): List<Boolean> {
        if (bridgeRevealed.size != 0 && bridgeRevealed.last().contains("X"))
            throw IllegalArgumentException(BridgeGameErrorMessages.INVALID_ACCESS_TO_CHECK.message)

        val addingBlock = generateBlock(ans)
        bridgeRevealed.add(addingBlock)

        if(addingBlock.contains("X")) return listOf(false)
        if(isSuccess()) return listOf(true, true)
        return listOf(true, false)
    }

    fun resetBridgeRevealed() {
        bridgeRevealed = mutableListOf()
    }

    private fun isSuccess(): Boolean {
        if(bridgeRevealed.size == bridgeInFog.size) return true
        return false
    }


    private fun generateBlock(ans: String): List<String> {
        if(checkAnswer(ans)) {
            if(ans == "U")
                return listOf("O", " ")
            if(ans == "D")
                return listOf(" ", "O")
        }
        else if(ans == "U")
            return listOf("X", " ")
        return listOf(" ", "X")
    }

    private fun checkAnswer(ans: String): Boolean {
        if (bridgeInFog[bridgeRevealed.size] == ans) {
            return true
        }
        return false
    }

    private fun makeLine(at: Int): String {
        val sb = StringBuilder("[")
        for(i in 0 until bridgeRevealed.size) {
            sb.append(" ${bridgeRevealed[i][at]} |")
        }
        sb.setLength(sb.length - 1)
        sb.append("]")
        return sb.toString()
    }
}