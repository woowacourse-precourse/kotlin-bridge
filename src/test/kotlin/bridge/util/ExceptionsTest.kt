package bridge.util

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ExceptionsTest {
    @ParameterizedTest
    @ValueSource(strings = ["-1", "0", "2", "21"])
    fun `3~20 숫자 범위 예외 확인`(element: String) {
        assertThrows<IllegalArgumentException> {
            Exceptions.checkInputBrideSize(element)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["ㅁㄴㅇ", "0ㄴ!", "asd", "string", "final"])
    fun `숫자 이외 문자 예외 확인`(element: String) {
        assertThrows<IllegalArgumentException> {
            Exceptions.checkInputBrideSize(element)
        }
    }
}