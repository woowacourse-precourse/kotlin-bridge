package bridge.utils

import bridge.utils.UserInputValidate
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class UserInputValidateTest {
    @ValueSource(strings = ["a", "$"])
    @ParameterizedTest
    fun `다리의 길이가 숫자가 아닐 경우 예외가 발생한다`(bridgeSize: String) {
        assertThrows<IllegalArgumentException> { UserInputValidate().validateBridgeSize(bridgeSize) }
    }

    @ValueSource(strings = ["2", "21"])
    @ParameterizedTest
    fun `다리의 길이가 유효한 범위 내의 숫자가 아닐 경우 예외가 발생한다`(bridgeSize: String) {
        assertThrows<IllegalArgumentException> { UserInputValidate().validateBridgeSize(bridgeSize) }
    }

    @ValueSource(strings = ["", "T", "UD"])
    @ParameterizedTest
    fun `입력받은 이동할 칸의 값이 U와 D 이외의 값이면 예외가 발생한다`(bridgeSize: String) {
        assertThrows<IllegalArgumentException> { UserInputValidate().validateMoving(bridgeSize) }
    }

    @ValueSource(strings = ["", "T", "UD"])
    @ParameterizedTest
    fun `재시작 여부 입력 값이 R(재시작)과 Q(종료) 이외의 값이면 예외가 발생한다`(bridgeSize: String) {
        assertThrows<IllegalArgumentException> { UserInputValidate().validateGameCommand(bridgeSize) }
    }
}