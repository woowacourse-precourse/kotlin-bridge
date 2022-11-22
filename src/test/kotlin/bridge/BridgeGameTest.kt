package bridge

import camp.nextstep.edu.missionutils.test.Assertions
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BridgeGameTest : NsTest() {

    @Test
    fun `첫 이동에 실패한 경우`() {
        Assertions.assertRandomNumberInRangeTest({
            run("3", "D", "Q")
            assertThat(output()).contains(
                "[   ]",
                "[ X ]",
                "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                "최종 게임 결과",
                "[   ]",
                "[ X ]",
                "게임 성공 여부: 실패",
                "총 시도한 횟수: 1"
            )
            val up = output().indexOf("[   ]")
            val down = output().indexOf("[ X ]")
            assertThat(up).isLessThan(down)
        }, 1, 0, 1, 0)
    }

    @Test
    fun `한번에 성공한 경우`() {
        Assertions.assertRandomNumberInRangeTest({
            run("4", "U","U","U","U")
            assertThat(output()).contains(
                "[ O | O | O | O ]",
                "[   |   |   |   ]",
                "최종 게임 결과",
                "[ O | O | O | O ]",
                "[   |   |   |   ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 1"
            )
            val up = output().indexOf("[ O | O | O | O ]")
            val down = output().indexOf("[   |   |   |   ]")
            assertThat(up).isLessThan(down)
        }, 1, 1, 1, 1)
    }

    override fun runMain() {
        BridgeGame(BridgeState()).play()
    }

}