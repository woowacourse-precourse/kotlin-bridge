package bridge

import bridge.Controller.BridgeController
import bridge.Model.BridgeData.bridgeLocation
import bridge.Model.BridgeData.bridgeShape
import bridge.Model.BridgeData.isPlay
import bridge.Model.BridgeData.roundResult
import bridge.Model.BridgeGame
import bridge.Model.BridgeGame.Companion.finalResult
import bridge.Model.BridgeGame.Companion.tryCount
import bridge.Model.BridgeResult
import bridge.Model.Referee
import bridge.util.Constant.DOWN_SIDE
import bridge.util.Constant.LOSE
import bridge.util.Constant.UP_SIDE
import bridge.util.Constant.WIN
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BridgeTest {
    private lateinit var bridgeController: BridgeController
    private lateinit var bridgeGame: BridgeGame

    @BeforeEach
    fun setUp() {
        bridgeController = BridgeController()
        bridgeGame = BridgeGame()
    }

    @Test
    @DisplayName("게임 시도 횟수 테스트")
    fun testTryCount() {
        bridgeController.retryGame()
        assertEquals(tryCount, 2)
    }

    @DisplayName("라운드 통과 여부 테스트")
    @ValueSource(strings = [DOWN_SIDE, UP_SIDE])
    @ParameterizedTest
    fun testRoundResult(input: String) {
        bridgeShape = listOf(UP_SIDE, DOWN_SIDE, DOWN_SIDE)
        bridgeController.moveBridge(input)
        when (input) {
            DOWN_SIDE -> assertEquals(finalResult, LOSE)
            UP_SIDE -> assertEquals(finalResult, WIN)
        }
    }

    @DisplayName("위 칸을 건널 수 있는 경우, 플레이어 입력 비교 테스트")
    @ValueSource(strings = [DOWN_SIDE, UP_SIDE])
    @ParameterizedTest
    fun testUpSide(input: String) {
        bridgeShape = listOf(UP_SIDE, DOWN_SIDE, DOWN_SIDE)
        when (input) {
            DOWN_SIDE -> assertEquals(bridgeGame.compareState(input), BridgeResult.DOWN_LOSE)
            UP_SIDE -> assertEquals(bridgeGame.compareState(input), BridgeResult.UP_WIN)
        }
    }

    @DisplayName("아래 칸을 건널 수 있는 경우, 플레이어 입력 비교 테스트")
    @ValueSource(strings = [DOWN_SIDE, UP_SIDE])
    @ParameterizedTest
    fun testDownSide(input: String) {
        bridgeShape = listOf(DOWN_SIDE, UP_SIDE, UP_SIDE)
        when (input) {
            DOWN_SIDE -> assertEquals(bridgeGame.compareState(input), BridgeResult.DOWN_WIN)
            UP_SIDE -> assertEquals(bridgeGame.compareState(input), BridgeResult.UP_LOSE)
        }
    }

    @Test
    @DisplayName("다리를 모두 건넜는지 확인 테스트")
    fun testGameSuccess() {
        bridgeShape = listOf(UP_SIDE, DOWN_SIDE, DOWN_SIDE)
        var referee = Referee()
        assertEquals(referee.judgeLastBridge(3), true)
    }

    @Test
    @DisplayName("재시작시 다리 데이터 초기화 테스트")
    fun testDataReset() {
        bridgeShape = listOf(UP_SIDE, DOWN_SIDE, DOWN_SIDE)
        roundResult = mutableListOf(BridgeResult.UP_LOSE)
        bridgeLocation = 2
        isPlay = false

        bridgeController.retryGame();
        assertEquals(roundResult.size, 0)
        assertEquals(bridgeLocation, 0)
        assertEquals(isPlay, true)
    }
}