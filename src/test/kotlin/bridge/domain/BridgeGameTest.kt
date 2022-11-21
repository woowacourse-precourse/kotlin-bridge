package bridge.domain

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.*

import bridge.data.Bridge
import org.junit.jupiter.api.assertThrows

internal class BridgeGameTest {

    @Test
    fun `isRunning_맨처음_true`() {
        val data = listOf(UP, DOWN, UP, DOWN)
        val bridgeGame = BridgeGame(Bridge(data))

        assertThat(bridgeGame.isRunning).isEqualTo(true)
    }

    @Test
    fun `isRunning_안틀리고진행중_true`() {
        val data = listOf(UP, UP, DOWN, DOWN)
        val test = listOf(UP, UP)
        val bridgeGame = BridgeGame(Bridge(data))

        test.forEach { bridgeGame.move(it) }
        assertThat(bridgeGame.isRunning).isEqualTo(true)
    }

    @Test
    fun `isRunning_진행도중틀렸을때_false`() {
        val data = listOf(UP, DOWN, UP, DOWN)
        val test = listOf(UP, DOWN, DOWN)
        val bridgeGame = BridgeGame(Bridge(data))

        test.forEach { bridgeGame.move(it) }
        assertThat(bridgeGame.isRunning).isEqualTo(false)
    }

    @Test
    fun `isRunning_끝까지다맞췄을때_false`() {
        val data = listOf(DOWN, DOWN, UP, UP)
        val test = listOf(DOWN, DOWN, UP, UP)
        val bridgeGame = BridgeGame(Bridge(data))

        test.forEach { bridgeGame.move(it) }
        assertThat(bridgeGame.isRunning).isEqualTo(false)
    }

    @Test
    fun `isCompleted_문제푸는도중_false`() {
        val data = listOf(DOWN, DOWN, UP, UP)
        val test = listOf(DOWN, DOWN)
        val bridgeGame = BridgeGame(Bridge(data))

        test.forEach { bridgeGame.move(it) }
        assertThat(bridgeGame.isCompleted).isEqualTo(false)
    }

    @Test
    fun `isCompleted_끝까지다맞췄을때_true`() {
        val data = listOf(DOWN, DOWN, UP, UP)
        val test = listOf(DOWN, DOWN, UP, UP)
        val bridgeGame = BridgeGame(Bridge(data))

        test.forEach { bridgeGame.move(it) }
        assertThat(bridgeGame.isCompleted).isEqualTo(true)
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

    @Test
    fun `retry_올바른실행_정상`() {
        val data = listOf(UP, DOWN, UP, DOWN)
        val test = listOf(UP, DOWN, DOWN)
        val bridge = Bridge(data)
        val bridgeGame = BridgeGame(bridge)

        for (floor in test) bridgeGame.move(floor)
        bridgeGame.retry()
        assertThat(bridgeGame.isRunning).isEqualTo(true)
    }

    @Test
    fun `retry_게임진행중에재시도_에러`() {
        val data = listOf(UP, DOWN, UP, DOWN)
        val test = listOf(UP, DOWN)
        val bridge = Bridge(data)
        val bridgeGame = BridgeGame(bridge)

        assertThrows<IllegalStateException> {
            for (floor in test) bridgeGame.move(floor)
            bridgeGame.retry()
        }
    }

    @Test
    fun `retry_게임종료후재시도_에러`() {
        val data = listOf(UP, DOWN, UP, DOWN)
        val test = listOf(UP, DOWN, UP, DOWN)
        val bridge = Bridge(data)
        val bridgeGame = BridgeGame(bridge)

        assertThrows<IllegalStateException> {
            for (floor in test) bridgeGame.move(floor)
            bridgeGame.retry()
        }
    }

    companion object {
        private val UP = Bridge.Floor.UP
        private val DOWN = Bridge.Floor.DOWN
    }
}