package bridge.ui

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.BeforeEach

internal class ValidatorTest {
    private lateinit var validator: Validator

    @BeforeEach
    fun setUp() {
        validator = Validator()
    }

    @Test
    fun `다리 길이 입력에 대한 예외 테스트`() {
        assertThatThrownBy {
            validator.handleMixedCharCase("afasf")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(Validator.MIXED_CHAR_ERROR_MSG)

        assertThatThrownBy {
            validator.handleOutOfRangeCase(-43)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(Validator.RANGE_BOUNDS_ERROR_MSG)
    }

    @Test
    fun `이동하려는 방향 입력에 대한 예외 테스트` () {
        assertThatThrownBy {
            validator.handleExceptionalDirection("dfakf")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(Validator.UP_DOWN_ERROR_MSG)
    }

    @Test
    fun `재시작_종료 여부 입력에 대한 예외 테스트` () {
        assertThatThrownBy {
            validator.handleExceptionalCommand("dfaf")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(Validator.RESTART_QUIT_ERROR_MSG)
    }
}