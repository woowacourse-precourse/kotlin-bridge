package bridge

import bridge.validator.OutputValidator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OutViewTest {
    @Test
    fun `첫 라운드 U를 입력하여 건널 수 있을 때 올바른 출력 테스트`() {
        assertThat("[ O ]\n[   ]").isEqualTo(OutputValidator.validatePrintMap(listOf("U","D","D"), 0, "U"))
    }

    @Test
    fun `첫 라운드 U를 입력하여 건널 수 없을 때 올바른 출력 테스트`() {
        assertThat("[   ]\n[ X ]").isEqualTo(OutputValidator.validatePrintMap(listOf("U","D","D"), 0, "D"))
    }
}