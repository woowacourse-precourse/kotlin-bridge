package bridge.model

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BridgeTest {

    @ValueSource(ints = [3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20])
    @ParameterizedTest
    fun `길이가 3이상 20이하인 다리를 만들 수 있다`(size: Int) {
        assertDoesNotThrow {
            Bridge.generateRandomBridge(size)
        }
    }

    @ValueSource(ints = [-1, -2, -3, 0, 1, 2])
    @ParameterizedTest
    fun `다리 길이가 3보다 작은 경우 예외를 발생시킨다`(size: Int) {
        assertThrows<IllegalArgumentException> {
            Bridge.generateRandomBridge(size)
        }
    }

    @ValueSource(ints = [23, 21, 22, 99, 999999])
    @ParameterizedTest
    fun `다리 길이가 20보다 큰 경우 예외를 발생시킨다`(size: Int) {
        assertThrows<IllegalArgumentException> {
            Bridge.generateRandomBridge(size)
        }
    }

    @Test
    fun `다리를 특정 방향으로 건널 수 있는지 여부를 알 수 있다`() {
        val moving = Direction.DOWN
        val bridge = Bridge(listOf("U", "D", "U", "U"))
        assert(bridge.canCross(moving, 1))
    }
}
