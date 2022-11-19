package bridge

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UnitTest : NsTest()  {
    /////////////////////////////////////////////////////////////
    //////////////////////////// 입력 ////////////////////////////
    /////////////////////////////////////////////////////////////
    @Test
    fun `자동으로 생성할 다리 길이를 입력 받는다`() {
        val numberGenerator: BridgeNumberGenerator = ApplicationTest.TestNumberGenerator(listOf(1, 0, 0))
        val bridgeMaker = BridgeMaker(numberGenerator) // return numbers.removeAt(0) 으로 대체된 식에 BridgeMaker 클래스에 입력
        val bridge: List<String> = bridgeMaker.makeBridge(3)
        Assertions.assertThat(bridge).containsExactly("U", "D", "D")
    }

    @Test
    fun `라운드마다 플레이어가 이동할 칸을 입력 받는다`() {
        val move = BridgeGame().move("U","D")
        Assertions.assertThat(move).contains("X")
    }

    @Test
    fun `게임 재시작, 종료 여부를 입력 받는다`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest({
            run("3", "D", "R", "D", "R", "U", "D", "U")
            Assertions.assertThat(output()).contains(
                "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                "최종 게임 결과",
                "[ O |   | O ]",
                "[   | O |   ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 3"
            )
        }, 1, 0, 1)
    }
    /////////////////////////////////////////////////////////////
    //////////////////////////// 출력 ////////////////////////////
    /////////////////////////////////////////////////////////////
    @Test
    fun `게임 시작, 다리 길이 입력 문구를 출력한다`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest({
            run("3", "U", "D", "U")
            Assertions.assertThat(output()).contains(
                "다리 건너기 게임을 시작합니다.",
                "다리의 길이를 입력해주세요.",
            )
        }, 1, 0, 1)
    }

    @Test
    fun `사용자가 이동할 때마다 다리 건너기 결과를 출력한다`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest({
            run("3", "U", "D", "U")
            Assertions.assertThat(output()).contains(
                "이동할 칸을 선택해주세요. (위: U, 아래: D)",
                "[ O |   ]",
                "[   | O ]",
            )
        }, 1, 0, 1)
    }

    @Test
    fun `게임 결과를 출력한다`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest({
            run("3", "U", "D", "U")
            Assertions.assertThat(output()).contains(
                "최종 게임 결과",
                "[ O |   | O ]",
                "[   | O |   ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 1"
            )
        }, 1, 0, 1)
    }
    /////////////////////////////////////////////////////////////
    //////////////////////////// 예외 ////////////////////////////
    /////////////////////////////////////////////////////////////
    @Test
    fun `3 이상 20 이하의 숫자를 입력할 수 있으며 올바른 값이 아니면 예외 처리한다`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest({
            run("21", "3", "U", "D", "U")
            Assertions.assertThat(output()).contains("[ERROR]")
        }, 1, 0, 1)
    }

    @Test
    fun `U(위 칸)와 D(아래 칸) 중 하나의 문자를 입력할 수 있으며 올바른 값이 아니면 예외 처리한다`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest({
            run("3", "F", "U", "D", "U")
            Assertions.assertThat(output()).contains("[ERROR]")
        }, 1, 0, 1)
    }

    @Test
    fun `R(재시작)과 Q(종료) 중 하나의 문자를 입력할 수 있으며 올바른 값이 아니면 예외 처리한다`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest({
            run("3", "D", "F", "Q")
            Assertions.assertThat(output()).contains("[ERROR]")
        }, 1, 0, 1)
    }

    override fun runMain() {
        main()
    }
}