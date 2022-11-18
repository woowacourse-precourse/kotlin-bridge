package bridge.model

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows


class BridgeTest {

    @Test
    fun `길이가 3이상 20이하인 다리를 만들 수 있다`() {
        val size = 20
        assertDoesNotThrow {
            Bridge.generate(size)
        }
    }

    @Test
    fun `다리 길이가 3보다 작은 경우 예외를 발생시킨다`() {
        val size = 1
        assertThrows<IllegalArgumentException> {
            Bridge.generate(size)
        }
    }

    @Test
    fun `다리 길이가 20보다 큰 경우 예외를 발생시킨다`() {
        val size = 21
        assertThrows<IllegalArgumentException> {
            Bridge.generate(size)
        }
    }

    @Test
    fun `다리에 U와 D가 아닌 문자가 있는 경우 예외를 발생시킨다`() {
        val directions = listOf("U", "D", "hi", "F", "-1")
        assertThrows<IllegalArgumentException> {
            Bridge(directions)
        }
    }

    @Test
    fun `다리 정보와 이동 정보를 비교할 수 있다`() {
        val moving = Direction.D
        val bridge = Bridge(listOf("U", "D", "U", "U"))
        assert(bridge.canCross(moving, 1))
    }
}