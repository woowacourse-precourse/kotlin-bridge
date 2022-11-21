package bridge.model

import bridge.MovingEventListener
import bridge.MovingEventManager
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

internal class BridgeGameTest {
    private val bridgeGame = BridgeGame(MovingEventManager())

    @Nested
    inner class `start 메소드는` {

        @Nested
        inner class `게임이 시작된 상태일 때 실행하면` {

            @Test
            fun `예외를 던진다`() {
                bridgeGame.start(listOf("U", "D", "D"))

                assertThatThrownBy { bridgeGame.start(listOf()) }.isInstanceOf(IllegalArgumentException::class.java)
            }
        }

        @Nested
        inner class `다리의 길이가 3 이상 20 이하가 아니면` {
            private val bridge = listOf<String>()

            @Test
            fun `예외를 던진다`() {
                assertThatThrownBy { bridgeGame.start(bridge) }.isInstanceOf(IllegalArgumentException::class.java)
            }
        }

        @Nested
        inner class `다리가 U와 D 이외의 값을 포함하면` {
            private val bridge = listOf("U", "D", "A")

            @Test
            fun `예외를 던진다`() {
                assertThatThrownBy { bridgeGame.start(bridge) }.isInstanceOf(IllegalArgumentException::class.java)
            }
        }
    }

    @Nested
    inner class `move 메소드는` {
        @Nested
        inner class `게임이 실행되고 있지 않을 때 실행되면` {
            private val moving = "U"

            @Test
            fun `예외를 던진다`() {
                assertThatThrownBy { bridgeGame.move(moving) }.isInstanceOf(IllegalStateException::class.java)
            }
        }

        @Nested
        inner class `실행되면` {
            private val movingEventListener = TestMovingEventListener()
            private val movingEventManager = MovingEventManager()
            private val bridgeGame = BridgeGame(movingEventManager)
            private val bridge = listOf("U", "D", "D")
            private val moving = "U"

            @Test
            fun `움직임 이벤트를 듣고 있는 객체에게 알린다`() {
                movingEventManager.subscribe(movingEventListener)
                bridgeGame.start(bridge)

                bridgeGame.move(moving)

                assertThat(movingEventListener.notified).isTrue
            }

            inner class TestMovingEventListener : MovingEventListener {

                var notified = false
                override fun notify(gameState: GameState) {
                    notified = true
                }
            }
        }

        @Nested
        inner class `이동할 수 없는 칸을 선택하면` {
            private val bridge = listOf("U", "D", "D")
            private val moving = "D"

            @Test
            fun `게임이 종료된다`() {
                bridgeGame.start(bridge)

                bridgeGame.move(moving)

                assertThat(bridgeGame.running()).isFalse
            }
        }

        @Nested
        inner class `다리의 끝까지 도달하면` {
            private val bridge = listOf("U", "D", "D")
            private val movings = listOf("U", "D", "D")

            @Test
            fun `게임이 종료된다`() {
                bridgeGame.start(bridge)

                movings.forEach { bridgeGame.move(it) }

                assertThat(bridgeGame.running()).isFalse
            }
        }
    }
}