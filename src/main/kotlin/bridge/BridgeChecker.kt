package bridge

class BridgeChecker(
    private val size: Int,
    private val bridgeMaker: BridgeMaker,
) {
    private val bridgeInFog = bridgeMaker.makeBridge(size)
    private var bridgeRevealed = mutableListOf<String>()

    fun toStringOpenPart(): String {
        val sb: StringBuilder = StringBuilder().also {
            it.append(makeLine("U")).append("\n")
            it.append(makeLine("D"))
        }
        return sb.toString()
    }

    fun updateWithChecking(ans: String) {
        if (bridgeRevealed.size != 0 && bridgeRevealed.last() == "X")
            throw IllegalArgumentException("[ERROR] 이미 실패한 BridgeGame: check 함수를 요청함")

        if (checkAnswer(ans)) {
            bridgeRevealed.add(bridgeInFog[bridgeRevealed.size])
            return
        }
        bridgeRevealed.add("X")
    }

    fun resetBridgeRevealed() {
        bridgeRevealed = mutableListOf()
    }

    private fun checkAnswer(ans: String): Boolean {
        if (bridgeInFog[bridgeRevealed.size] == ans)
            return true
        return false
    }

    private fun makeLine(target: String): String {
        val sb = StringBuilder("[")
        for (block in bridgeRevealed) {
            if (block == target) sb.append(" O |")
            else if (block == "X") sb.append(" X |")
        }
        sb.dropLast(0)
        sb.append("]")
        return sb.toString()
    }
}