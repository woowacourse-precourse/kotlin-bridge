package bridge

import bridge.view.validator.OutputValidator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class OutViewTest {

    companion object {
        @JvmStatic
        fun upBridge() = listOf(
            Arguments.of(" O ", listOf("U", "D", "D"), 0, "U"),
            Arguments.of("   ", listOf("U", "D", "D"), 0, "D"),
        )

        @JvmStatic
        fun downBridge() = listOf(
            Arguments.of("   ", listOf("U", "D", "D"), 0, "U"),
            Arguments.of(" X ", listOf("U", "D", "D"), 0, "D"),
        )

    }

    @ParameterizedTest
    @MethodSource("upBridge")
    fun `위쪽 리스트 올바른 출력 테스트`(
        upPrint: String,
        upBridge: List<String>,
        round: Int,
        direction: String,
    ) {
        assertThat(upPrint).isEqualTo(OutputValidator.validateUpSideMap(upBridge, round, direction))
    }

    @ParameterizedTest
    @MethodSource("downBridge")
    fun `아래쪽 리스트 올바른 출력 테스트`(
        downPrint: String,
        downBridge: List<String>,
        round: Int,
        direction: String,
    ) {
        assertThat(downPrint).isEqualTo(OutputValidator.validateDownSideMap(downBridge, round, direction))
    }

    @Test
    fun `첫번째 라운드 오답일 때 최종 게임 결과 출력 테스트`() {
    }
}