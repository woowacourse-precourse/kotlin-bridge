package bridge.domain

import bridge.*
import bridge.data.*
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class GameTest : NsTest() {
    private val bridgeGame = BridgeGame()

    @Test
    fun `게임 시작 - 브릿지 생성 테스트`() {
        val numberGenerator: BridgeNumberGenerator = ApplicationTest.TestNumberGenerator(listOf(ZERO, ZERO, ZERO, ONE))
        val bridgeMaker = BridgeMaker(numberGenerator)
        val bridge: List<String> = bridgeMaker.makeBridge(FOUR)
        Assertions.assertThat(bridge).containsExactly(DOWN, DOWN, DOWN, UP)
    }

    @Test
    fun `게임 시작 - 브릿지 길이 테스트`() {
        val size = FIVE
        val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
        val bridge: List<String> = bridgeMaker.makeBridge(size)
        Assertions.assertThat(bridge).hasSize(size)
    }

    @Test
    fun `게임 진행 - 재시도 테스트`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest({
            run("3", "D", "R", "U", "D", "U")
            Assertions.assertThat(output()).contains(
                "최종 게임 결과",
                "[ O |   | O ]",
                "[   | O |   ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 2"
            )
            val upSideIndex = output().indexOf("[ O |   | O ]")
            val downSideIndex = output().indexOf("[   | O |   ]")
            Assertions.assertThat(upSideIndex).isLessThan(downSideIndex)
        }, 1, 0, 1)
    }

    @Test
    fun `게임 종료 - 나가기 테스트`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest({
            run("3", "D", "R", "U", "U", "Q")
            Assertions.assertThat(output()).contains(
                "최종 게임 결과",
                "[ O | X ]",
                "[   |   ]",
                "게임 성공 여부: 실패",
                "총 시도한 횟수: 2"
            )
            val upSideIndex = output().indexOf("[ O | X ]")
            val downSideIndex = output().indexOf("[   |   ]")
            Assertions.assertThat(upSideIndex).isLessThan(downSideIndex)
        }, 1, 0, 1)
    }

    @Test
    fun `게임 종료 - 게임 총 횟수 테스트`() {
        repeat(3) { bridgeGame.retry() }
        Assertions.assertThat(bridgeGame.getCoin()).isEqualTo(4)
    }

    override fun runMain() {
        main()
    }


}