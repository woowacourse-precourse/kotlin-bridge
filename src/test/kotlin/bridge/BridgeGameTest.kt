package bridge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BridgeGameTest {

    @Test
    fun `이동할 수 있는 경우 판단`() {
        assertThat(bridgeGame.move(1, "D")).isEqualTo(true)
    }

    @Test
    fun `이동할 수 없는 경우 판단`() {
        assertThat(bridgeGame.move(0, "D")).isEqualTo(false)
    }

    @Test
    fun `이동했을 때 결과 추가 확인`() {
        bridgeGame.move(0, "U")
        bridgeGame.move(1, "U")
        val firstRow = bridgeGame.getResult().getFirstRowResult()
        val secondRow = bridgeGame.getResult().getSecondRowResult()
        val firstRowExpectedResult = listOf("O", "X")
        val secondRowExpectedResult = listOf(" ", " ")
        assertThat(firstRow).isEqualTo(firstRowExpectedResult)
        assertThat(secondRow).isEqualTo(secondRowExpectedResult)
    }


    companion object {

        lateinit var testBridge: Bridge
        lateinit var bridgeGame: BridgeGame

        @BeforeAll
        @JvmStatic
        fun initBridge() {
            testBridge = Bridge(listOf("U", "D", "D"))
            bridgeGame = BridgeGame(InputView(), OutputView(), testBridge)
        }
    }
}