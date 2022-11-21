package bridge.model

import bridge.MovingEventManager
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
}