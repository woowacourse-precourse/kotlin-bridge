package bridge.ui.validator

import camp.nextstep.edu.missionutils.test.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class ValidatorTest {
    @Test
    fun `다리 크기가 3 이상 20 이하의 숫자가 아니면 예외 발생`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { InputValidator.validateBridgeSize(bridgeSize = "21") }
        }
    }

    @Test
    fun `이동할 칸 입력이 U 또는 D가 아닌 문자면 예외 발생`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { InputValidator.validateBridgeSize(bridgeSize = "A") }
        }
    }

    @Test
    fun `게임 진행 여부 입력이 R 또는 Q가 아닌 문자면 예외 발생`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { InputValidator.validateBridgeSize(bridgeSize = "A") }
        }
    }
}