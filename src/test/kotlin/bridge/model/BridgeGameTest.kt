package bridge.model

import bridge.MovingEventListener
import bridge.MovingEventManager
import bridge.QuitEventListener
import bridge.QuitEventManager
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

internal class BridgeGameTest {

    @Nested
    inner class `start 메소드는` {

        @Nested
        inner class `게임이 시작된 상태일 때 실행하면` {
            private val bridgeGame = BridgeGame(MovingEventManager(), QuitEventManager())
            private val bridge = listOf("U", "D", "D")

            @Test
            fun `예외를 던진다`() {
                bridgeGame.start(bridge)

                assertThatThrownBy { bridgeGame.start(listOf()) }.isInstanceOf(IllegalArgumentException::class.java)
            }
        }

        @Nested
        inner class `다리의 길이가 3 이상 20 이하가 아니면` {
            private val bridgeGame = BridgeGame(MovingEventManager(), QuitEventManager())
            private val bridge = listOf<String>()

            @Test
            fun `예외를 던진다`() {
                assertThatThrownBy { bridgeGame.start(bridge) }.isInstanceOf(IllegalArgumentException::class.java)
            }
        }

        @Nested
        inner class `다리가 U와 D 이외의 값을 포함하면` {
            private val bridgeGame = BridgeGame(MovingEventManager(), QuitEventManager())
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
        inner class `게임이 시작되지 않았을 때 실행되면` {
            private val bridgeGame = BridgeGame(MovingEventManager(), QuitEventManager())
            private val moving = "U"

            @Test
            fun `예외를 던진다`() {
                assertThatThrownBy { bridgeGame.move(moving) }.isInstanceOf(IllegalStateException::class.java)
            }
        }

        @Nested
        inner class `게임이 성공한 상태에서 실행되면` {
            private val bridgeGame = BridgeGame(MovingEventManager(), QuitEventManager())
            private val bridge = listOf("U", "D", "D")
            private val movings = listOf("U", "D", "D")

            @Test
            fun `예외를 던진다`() {
                bridgeGame.start(bridge)
                movings.forEach { bridgeGame.move(it) }

                assertThatThrownBy { bridgeGame.move("U") }.isInstanceOf(IllegalStateException::class.java)
            }
        }

        @Nested
        inner class `게임이 실패한 상테에서 실행되면` {
            private val bridgeGame = BridgeGame(MovingEventManager(), QuitEventManager())
            private val bridge = listOf("U", "D", "D")
            private val moving = "D"
            @Test
            fun `예외를 던진다`() {
                bridgeGame.start(bridge)
                bridgeGame.move(moving)

                assertThatThrownBy { bridgeGame.move("U") }.isInstanceOf(IllegalStateException::class.java)
            }
        }

        @Nested
        inner class `실행되면` {
            private val movingEventListener = TestMovingEventListener()
            private val movingEventManager = MovingEventManager()
            private val bridgeGame = BridgeGame(movingEventManager, QuitEventManager())
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
                override fun update(gameMapStatus: GameMapStatus) {
                    notified = true
                }
            }
        }
    }

    @Nested
    inner class `successed 메소드는` {

        @Nested
        inner class `사용자가 다리의 끝까지 도달했다면` {
            private val bridge = listOf("U", "D", "D")
            private val movings = listOf("U", "D", "D")
            private val bridgeGame = BridgeGame(MovingEventManager(), QuitEventManager())

            @Test
            fun `참을 반환한다`() {
                bridgeGame.start(bridge)

                movings.forEach { bridgeGame.move(it) }

                assertThat(bridgeGame.succeeded()).isTrue
            }
        }

        @Nested
        inner class `게임이 시작되지 않았다면` {
            private val bridgeGame = BridgeGame(MovingEventManager(), QuitEventManager())

            @Test
            fun `예외를 던진다`() {
                assertThatThrownBy { bridgeGame.succeeded() }.isInstanceOf(IllegalStateException::class.java)
            }
        }
    }

    @Nested
    inner class `quit 메소드는` {

        @Nested
        inner class `게임이 시작하지 않았을 때 실행되면` {
            private val bridgeGame = BridgeGame(MovingEventManager(), QuitEventManager())

            @Test
            fun `예외를 던진다`() {
                assertThatThrownBy { bridgeGame.quit() }.isInstanceOf(IllegalStateException::class.java)
            }
        }

        @Nested
        inner class `게임을 시작하고 나서 실행되면` {
            private val quitEventListener = TestQuitEventListener()
            private val quitEventManager = QuitEventManager()
            private val bridgeGame = BridgeGame(MovingEventManager(), quitEventManager)
            private val bridge = listOf("U", "D", "D")

            @Test
            fun `종료 이벤트를 듣고 있는 객체에게 알린다`() {
                quitEventManager.subscribe(quitEventListener)
                bridgeGame.start(bridge)

                bridgeGame.quit()

                assertThat(quitEventListener.notified).isTrue
            }

            inner class TestQuitEventListener : QuitEventListener {
                var notified: Boolean = false
                override fun update(gameMapStatus: GameMapStatus, gameResult: GameResult) {
                    notified = true
                }
            }
        }
    }

    @Nested
    inner class `retry 메소드는` {

        @Nested
        inner class `게임이 시작하지 않은 상태에서 실행하면` {
            private val bridgeGame = BridgeGame(MovingEventManager(), QuitEventManager())

            @Test
            fun `예외를 던진다`() {
                assertThatThrownBy { bridgeGame.retry() }.isInstanceOf(IllegalStateException::class.java)
            }
        }

        @Nested
        inner class `중지되지 않은 상태에서 실행하면` {
            private val bridgeGame = BridgeGame(MovingEventManager(), QuitEventManager())
            private val bridge = listOf("U", "D", "D")
            @Test
            fun `예외를 던진다`() {
                bridgeGame.start(bridge)

                assertThatThrownBy { bridgeGame.retry() }.isInstanceOf(IllegalStateException::class.java)
            }
        }
        
        @Nested
        inner class `게임이 중지 상태일 때 실행하면` {
            private val bridgeGame = BridgeGame(MovingEventManager(), QuitEventManager())
            private val bridge = listOf("U", "D", "D")
            @Test
            fun `게임을 재시작한다`() {
                bridgeGame.start(bridge)
                bridgeGame.move("D")
                
                assertThatCode { bridgeGame.retry() }.doesNotThrowAnyException()
            }
        }
    }
}