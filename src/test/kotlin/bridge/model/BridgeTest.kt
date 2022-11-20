package bridge.model

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class BridgeTest {

    @CsvSource("3, 20")
    @ParameterizedTest
    fun `길이가 3이상 20이하인 다리를 만들 수 있다`(start: Int, end: Int) {
        val sizeRange = start..end
        for (size in sizeRange) {
            assertDoesNotThrow {
                Bridge.generateRandomBridge(size)
            }
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

    @ValueSource(ints = [3, 5, 7, 18, 20])
    @ParameterizedTest
    fun `다리 길이를 벗어나 건널 수 있는지 여부를 물어본다면 예외를 발생시킨다`(size: Int) {
        val bridge = Bridge.generateRandomBridge(size)
        assertThrows<IndexOutOfBoundsException> {
            bridge.canCross(Direction.DOWN, size + 1)
        }
    }

    @ValueSource(ints = [3, 5, 7, 18, 20])
    @ParameterizedTest
    fun `다리의 끝을 알 수 있다`(size: Int) {
        val bridge = Bridge.generateRandomBridge(size)
        assert(bridge.isBridgeEnd(size - 1))
    }
}
