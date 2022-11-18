package bridge.domain

import bridge.resources.BRIDGE_MAX_LENGTH
import bridge.resources.BRIDGE_MIN_LENGTH
import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class BridgeMakerTest {
    @DisplayName("gen")
    @ParameterizedTest(name = "U와 D를 랜덤으로 생성된다. {argumentsWithNames}")
    @CsvSource("1, U", "0, D")
    fun `U와 D를 랜덤으로 생성된다`(input: Int, output: String) {
        assertRandomNumberInRangeTest({
            val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
            val method = bridgeMaker.javaClass.getDeclaredMethod("generateKey")
            method.isAccessible = true
            val parameters = arrayOfNulls<Any>(0)
            val getElement = method.invoke(bridgeMaker, *parameters)
            Assertions.assertThat(getElement.equals(output))
        }, input)
    }

    @Test
    fun `입력받은 값에 따라 문자 리스트를 만든다`() {
        assertRandomNumberInRangeTest({
            val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(4)
            Assertions.assertThat(bridge == listOf("U", "U", "U", "D"))
        }, 1, 1, 1, 0)
    }

    @ParameterizedTest(name = "범위 이외에 값이 들어오면 오류 처리한다. {argumentsWithNames}")
    @ValueSource(ints = [-1, BRIDGE_MIN_LENGTH - 1, BRIDGE_MAX_LENGTH + 1])
    fun `범위 이외에 값이 들어오면 오류 처리한다`(input: Int) {
        assertThrows<IllegalArgumentException> {
            BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(input)
        }
    }
}
