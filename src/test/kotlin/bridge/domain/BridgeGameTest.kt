package bridge.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

internal class BridgeGameTest {
    private lateinit var bridgeGame: BridgeGame

    @BeforeEach
    fun setUp() {
        bridgeGame = BridgeGame()
    }

    @Test
    fun `이동 가능한 칸과 사용자의 입력값을 비교한다` () {
        val actual = bridgeGame.move("U", "U")
        val expected = true
        assertThat(actual).isEqualTo(expected)
    }
}