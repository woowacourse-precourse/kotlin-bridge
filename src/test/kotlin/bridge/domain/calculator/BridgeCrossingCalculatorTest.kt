package bridge.domain.calculator

import bridge.domain.moving.Moving
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BridgeCrossingCalculatorTest {
    @BeforeEach
    fun setUp() {
        BridgeCrossingCalculator.clearBridgeCrossingInfo()
        BridgeCrossingCalculator.updateBridgeCrossingInfo(Moving.UP, true)
        BridgeCrossingCalculator.updateBridgeCrossingInfo(Moving.DOWN, true)
        BridgeCrossingCalculator.updateBridgeCrossingInfo(Moving.UP, false)
    }

    @Test
    fun `다리 건너기에 실패했는지 확인`() {
        Assertions.assertThat(
            BridgeCrossingCalculator.isCrossingFail()
        ).isEqualTo(true)
    }

    @Test
    fun `현재까지 건넌 다리 정보에 대해 맵이 잘 생성되는지 확인`() {
        Assertions.assertThat(
            BridgeCrossingCalculator.getCurrentMap()
        ).isEqualTo(
            listOf(
                "[ O |   | X ]",
                "[   | O |   ]"
            )
        )

        val upSideIndex = BridgeCrossingCalculator.getCurrentMap().indexOf("[ O |   | X ]")
        val downSideIndex = BridgeCrossingCalculator.getCurrentMap().indexOf("[   | O |   ]")

        Assertions.assertThat(upSideIndex).isEqualTo(0)
        Assertions.assertThat(downSideIndex).isEqualTo(1)
    }

    @Test
    fun `게임 최종 결과를 잘 반환하는 지 테스트`() {
        Assertions.assertThat(
            BridgeCrossingCalculator.getFinalGameResult()
        ).isEqualTo(FINAL_FAIL_RESULT)
    }

    companion object {
        private const val FINAL_SUCCESS_RESULT = "성공"
        private const val FINAL_FAIL_RESULT = "실패"
    }
}