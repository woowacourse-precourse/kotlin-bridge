package bridge

import bridge.validator.OutputValidator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class OutViewTest {

    companion object {
        @JvmStatic
        fun bridge() = listOf(
            Arguments.of("[ O ]", "[   ]", listOf("U", "D", "D"), 0, "U"),
            Arguments.of("[   ]", "[ O ]", listOf("D", "D", "D"), 0, "D"),
        )

    }

    @ParameterizedTest
    @MethodSource("bridge")
    fun `첫번째 라운드 올바른 출력 테스트`(
        upPrint: String,
        downPrint: String,
        bridge: List<String>,
        round: Int,
        direction: String,
    ) {
        assertThat(upPrint + "\n" + downPrint).isEqualTo(OutputValidator.validatePrintMap(bridge, round, direction))
    }

    @Test
    fun `첫번째 라운드 오답일 때 최종 게임 결과 출력 테스트`() {
        assertThat("최종 게임 결과" + "\n" + "[   ]" + "\n" + "[ X ]" + "\n" + "게임 성공 여부: 실패" + "\n" + "총 시도한 횟수: 1"
        ).isEqualTo(OutputValidator.validatePrintResult(false, 1))

    }
}