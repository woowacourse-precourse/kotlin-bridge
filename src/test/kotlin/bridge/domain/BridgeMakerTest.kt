package bridge.domain

import bridge._assist.TestNumberGenerator2.Companion.generateBridge
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class BridgeMakerTest {

    @Test
    fun `다리생성_1or0_정상`() {
        val bridge: List<String> = generateBridge(1, 0, 0)
        assertThat(bridge).containsExactly("U", "D", "D")
    }

    @ParameterizedTest
    @ValueSource(ints = [-2, -1, 2, 3, 4, 5])
    fun `다리생성_not1or0_예외`(exceptionNumber: Int) {
        assertThrows<ArrayIndexOutOfBoundsException> {
            generateBridge(1, 0, 0, exceptionNumber)
        }
    }

}