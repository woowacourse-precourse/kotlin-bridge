package bridge

class BridgeChecker(
    private val size: Int,
    private val bridgeMaker: BridgeMaker,
) {
    private val bridgeInFog = bridgeMaker.makeBridge(size)
    private var bridgeRevealed = mutableListOf<List<String>>()

    fun toStringOpenPart(): String {
        val sb: StringBuilder = StringBuilder().also {
            it.append(makeLine(0)).append("\n")
            it.append(makeLine(1))
        }
        return sb.toString()
    }

    fun updateWithChecking(ans: String) {
        if (bridgeRevealed.size != 0 && bridgeRevealed.last().contains("X"))
            throw IllegalArgumentException("[ERROR] 이미 실패한 BridgeGame: check 함수를 요청함")

        bridgeRevealed.add(generateBlock(ans))
    }

    fun resetBridgeRevealed() {
        bridgeRevealed = mutableListOf()
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