package bridge

import bridge.OutputView.Companion.INPUT_MOVING
import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BridgeGameTest : NsTest() {
    override fun runMain() {
        main()
    }

    // 찾아보니까 readLine()의 개수를 일치시켜야해서 지금은 사용할 수 없는 테스트
//    @Test
//    fun `다리길이 정상적인 입력값을 받았을 경우`() {
//        assertSimpleTest {
//            run("3")
//            assertThat(output()).contains(INPUT_MOVING)
//        }
//    }

    @Test
    fun `다리 길이 입력값에 문자가 들어갈 경우 예외 처리`() {
        // 문자가 들어갔을 경우
        assertSimpleTest {
            runException("10j")
            assertThat(output()).contains("[ERROR]")
        }

        // 3-20 범위를 벗어났을 경우
        assertSimpleTest {
            runException("33")
            assertThat(output()).contains("[ERROR]")
        }
    }

    @Test
    fun `이동할 칸 입력 값에 U 또는 D가 들어가지 않았을 경우 예외처리`() {
        // 3-20 범위를 벗어났을 경우
        assertSimpleTest {
            runException("3", "위", "u")
            assertThat(output()).contains("[ERROR]")
        }
    }

    // todo 테스트는 잘 작성한 것 같은데, 내 output에 이상이 있는 것 같다..? 잘 모르겠다.
    // -> BridgeGame이 static으로 선언되서 BridgeGame 내의 BridgeGameManager의 position 값을 공유해서 오류가 났었다.
    @Test
    fun `이동한 결과에 따른 맵을 출력하는지 확인`() {
        assertRandomNumberInRangeTest ({
            run("5", "U", "U", "D", "U", "D")
            assertThat(output()).contains(
                "최종 게임 결과",
                "[ O | O |   | O |   ]",
                "[   |   | O |   | O ]",
                "총 시도한 횟수: 1"
            )
        }, 1, 1, 0, 1, 0)
    }

    @Test
    fun `이동에 실패할 경우 재시작 여부를 묻는지 확인`() {
        assertRandomNumberInRangeTest ({
            run("5", "U", "U", "D", "D", "Q")
            assertThat(output()).contains(
                "[ O | O |   |   ]",
                "[   |   | O | X ]")
        }, 1, 1, 0, 1, 0)
    }
}