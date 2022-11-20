package bridge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BridgeGameTest {
    private val realBridges = listOf<String>("U", "D", "U", "U", "D")
    private val bridgeGameTest = BridgeGame(realBridges)

    @Test
    fun `위로 제대로 갔는지 검사`() {
        val bridgeGame = BridgeGame(realBridges)
        val result = bridgeGame.move("U")
        val expected = BridgeGame.BridgeMoveResult.MOVE_SUCCESS
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `처음에 아래로 가면 실패하는게 맞는지 검사`() {
        val bridgeGame = BridgeGame(realBridges)
        val result = bridgeGame.move("D")
        val expected = BridgeGame.BridgeMoveResult.MOVE_FAILED
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `마지막 다리 건너면 MOVE_END 맞는지 검사`() {
        val input = listOf<String>("U", "D", "U", "U", "D")
        var result = BridgeGame.BridgeMoveResult.MOVE_SUCCESS
        for (i in input.indices) {
            val curResult = bridgeGameTest.move(input[i])
            if (curResult == BridgeGame.BridgeMoveResult.MOVE_FAILED) {
                result = BridgeGame.BridgeMoveResult.MOVE_FAILED
                break
            }
            result=curResult
        }

        val expected = BridgeGame.BridgeMoveResult.MOVE_END
        assertThat(result).isEqualTo(expected)
    }
}