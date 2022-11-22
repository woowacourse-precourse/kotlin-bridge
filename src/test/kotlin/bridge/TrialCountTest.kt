package bridge

import bridge.console.BridgeGameConsole
import bridge.model.Bridge
import bridge.model.GameInfo
import bridge.utils.Constants
import camp.nextstep.edu.missionutils.test.Assertions
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test

class TrialCountTest: NsTest() {
    val bridge = Bridge(listOf(Constants.UP_SYMBOL, Constants.DOWN_SYMBOL, Constants.UP_SYMBOL))

    @AfterEach
    fun `enum class 게임 횟수 인자 초기화`(){
        GameInfo.GAME_TRIAL_COUNT.gameTrialCount = 0
    }

    @Test
    fun `8번 재시도 할 경우 게임 횟수가 8번 증가한다`(){
        Assertions.assertRandomNumberInRangeTest({
            run("4", "D", "R", "D", "R", "D", "R", "D", "R", "D", "R", "D", "R", "D", "R", "D", "R", "D", "Q")
            org.assertj.core.api.Assertions.assertThat(output()).contains(
                "총 시도한 횟수: 9"
            )
        }, 1, 0, 1, 0)
    }

    override fun runMain() {
        BridgeGameConsole().startGame()
    }
}