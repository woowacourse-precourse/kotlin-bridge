package bridge

import bridge.Controller.BridgeController
import bridge.Model.BridgeData.bridgeLocation
import bridge.Model.BridgeData.bridgeShape
import bridge.Model.BridgeData.bridgeSize
import bridge.Model.BridgeData.isPlay
import bridge.Model.BridgeData.roundResult
import bridge.Model.BridgeResult
import bridge.Model.Referee
import bridge.util.Constant.GAME_OVER
import bridge.util.Constant.TOTAL_TRY
import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class BridgeTest : NsTest() {
    @Test
    @DisplayName("다리 건너기 실패시 재시작 여부 묻기 테스트")
    fun testRetryQuestion() {
        assertRandomNumberInRangeTest({
            run("3", "D", "D","Q")
            assertThat(output()).contains(
                "[   |   ]",
                "[ O | X ]",
                "$GAME_OVER"
            )
        }, 0, 1, 1)
    }

    @Test
    @DisplayName("게임 시도 횟수 테스트")
    fun testTryCount() {
        assertRandomNumberInRangeTest({
            run("3", "D", "D", "R", "D", "U", "D", "R", "D", "U", "U")
            assertThat(output()).contains("${TOTAL_TRY}3")
        }, 0, 1, 1)
    }

    @Test
    @DisplayName("다리를 모두 건넜는지 확인 테스트")
    fun testGameSuccess() {
        bridgeShape = listOf<String>("U", "D", "D")
        var referee = Referee()
        assertEquals(referee.judgeLastBridge(3), true)
    }

    @Test
    @DisplayName("재시작시 다리 데이터 초기화 테스트")
    fun testDataReset() {
        var bridgeController = BridgeController()
        bridgeSize = 3
        bridgeController.makeBridge(3)
        roundResult = mutableListOf(BridgeResult.UP_LOSE)
        bridgeLocation = 2
        isPlay = false

        bridgeController.retryGame()

        assertEquals(roundResult.size, 0)
        assertEquals(bridgeLocation,0)
        assertEquals(isPlay, true)
    }

    @Test
    @DisplayName("다리 건너기 실패 후 종료하는 기능 테스트")
    fun testFailQuit() {
        assertRandomNumberInRangeTest({
            run("3", "U", "D", "D","Q")
            assertThat(output()).contains(
                "최종 게임 결과",
                "[ O |   |   ]",
                "[   | O | X ]",
                "게임 성공 여부: 실패",
                "총 시도한 횟수: 1"
            )
            val upSideIndex = output().indexOf("[ O |   |   ]")
            val downSideIndex = output().indexOf("[   | O | X ]")
            assertThat(upSideIndex).isLessThan(downSideIndex)
        }, 1, 0, 1)
    }

    @Test
    @DisplayName("다리 건너기 실패 후 재시작하는 기능 테스트")
    fun testFailRetry() {
        assertRandomNumberInRangeTest({
            run("3", "U", "D", "D", "R", "U", "D", "U")
            assertThat(output()).contains(
                "최종 게임 결과",
                "[ O |   | O ]",
                "[   | O |   ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 2"
            )
            val upSideIndex = output().indexOf("[ O |   | O ]")
            val downSideIndex = output().indexOf("[   | O |   ]")
            assertThat(upSideIndex).isLessThan(downSideIndex)
        }, 1, 0, 1)
    }

    override fun runMain() {
        main()
    }
}