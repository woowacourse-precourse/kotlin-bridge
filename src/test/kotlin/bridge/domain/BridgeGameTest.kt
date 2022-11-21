package bridge.domain

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.*

import bridge.data.Bridge
import org.junit.jupiter.api.assertThrows

internal class BridgeGameTest {

    @Test
    fun `move_올바른값1_정상`() {
        val data = listOf(UP, UP, DOWN, DOWN)
        val test = listOf(UP, UP, UP)
        val bridge = Bridge(data)
        val bridgeGame = BridgeGame(bridge)

        val result = test.map {
            bridgeGame.move(it)
        }
        assertThat(result).containsExactly(true, true, false)
    }

    @Test
    fun `move_올바른값2_정상`() {
        val data = listOf(UP, DOWN, UP, DOWN)
        val test = listOf(UP, DOWN, UP, DOWN)
        val bridge = Bridge(data)
        val bridgeGame = BridgeGame(bridge)

        val result = test.map {
            bridgeGame.move(it)
        }
        assertThat(result).containsExactly(true, true, true, true)
    }

    @Test
    fun `move_틀렸는데게임을계속진행_에러`() {
        val data = listOf(UP, DOWN, UP, DOWN)
        val test = listOf(UP, DOWN, DOWN, DOWN)
        val bridge = Bridge(data)
        val bridgeGame = BridgeGame(bridge)

        assertThrows<IllegalStateException> {
            for (floor in test) bridgeGame.move(floor)
        }
    }

    @Test
    fun `move_이미끝났는데게임을계속진행_에러`() {
        val data = listOf(UP, DOWN, UP, DOWN)
        val test = listOf(UP, DOWN, UP, DOWN, UP)
        val bridge = Bridge(data)
        val bridgeGame = BridgeGame(bridge)

        assertThrows<IllegalStateException> {
            for (floor in test) bridgeGame.move(floor)
        }
    }

    companion object {
        private val UP = Bridge.Floor.UP
        private val DOWN = Bridge.Floor.DOWN
    }
}