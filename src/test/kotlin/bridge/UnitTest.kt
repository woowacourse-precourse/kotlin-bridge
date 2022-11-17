package bridge

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class UnitTest : NsTest()  {
    @Test
    fun `자동으로 생성할 다리 길이를 입력 받는다`() {
        val numberGenerator: BridgeNumberGenerator = ApplicationTest.TestNumberGenerator(listOf(1, 0, 0)) // ApplicationTest.TestNumberGenerator 받은 리스트 형식지정
        val bridgeMaker = BridgeMaker(numberGenerator) // 위 형식으로 입력시킨걸 BridgeMaker 클래스에 입력
        val bridge: List<String> = bridgeMaker.makeBridge(3) // BridgeMaker 클래스안의 함수 makeBridge 3 입력
        Assertions.assertThat(bridge).containsExactly("U", "D", "D")
    }

    @Test
    fun `라운드마다 플레이어가 이동할 칸을 입력 받는다`() {
        val checkMove = BridgeGame().move("D")
        Assertions.assertThat(checkMove).containsExactly()
    }

    @Test
    fun `게임 재시작, 종료 여부를 입력 받는다`() { // 재
        val checkEnd = BridgeGame().retry("Q")
        val checkRetry = BridgeGame().retry("R")
        Assertions.assertThat(checkEnd).containsExactly()
        Assertions.assertThat(checkRetry).containsExactly()

    @Test
    fun `게임 시작, 다리 길이 입력 문구를 출력한다`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest({
            run("3")
            Assertions.assertThat(output()).contains(
                "다리 건너기 게임을 시작합니다.",
                "다리의 길이를 입력해주세요.",
                "3"
            )
        }, 1, 0, 1)
    }

    @Test
    fun `사용자가 이동할 때마다 다리 건너기 결과를 출력한다`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest({
            run("3", "U", "D", "U")
            Assertions.assertThat(output()).contains(
                "이동할 칸을 선택해주세요. (위: U, 아래: D)",
                "D",
                "최종 게임 결과",
                "[ O |   | O ]",
                "[   | O |   ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 1"
            )
        }, 1, 0, 1)
    }

    @Test
    fun `게임 재시작 문구를 출력한다`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest({
            run("3", "U", "D", "D")
            Assertions.assertThat(output()).contains(
                "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                "Q",
                "최종 게임 결과",
                "[ O |   |   ]",
                "[   | O | X ]",
                "게임 성공 여부: 실패",
                "총 시도한 횟수: 1"
            )
        }, 1, 0, 1)
    }

    @Test
    fun `3 이상 20 이하의 숫자를 입력할 수 있으며 올바른 값이 아니면 예외 처리한다`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest {
            runException("21")
            Assertions.assertThat(output()).contains("[ERROR]")
        }
    }

    @Test
    fun `U(위 칸)와 D(아래 칸) 중 하나의 문자를 입력할 수 있으며 올바른 값이 아니면 예외 처리한다`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest {
            runException("3", "F")
            Assertions.assertThat(output()).contains("[ERROR]")
        }
    }

    @Test
    fun `R(재시작)과 Q(종료) 중 하나의 문자를 입력할 수 있으며 올바른 값이 아니면 예외 처리한다`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest {
            runException("3", "D", "F")
            Assertions.assertThat(output()).contains("[ERROR]")
        }
    }

    override fun runMain() {
        main()
    }
}