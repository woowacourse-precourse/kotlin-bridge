package bridge

import camp.nextstep.edu.missionutils.test.NsTest
import domain.BridgeMaker
import domain.BridgeNumberGenerator
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class UnitTest : NsTest() {
   /* @Test
    fun `다리 생성 테스트`() {
        val numberGenerator: BridgeNumberGenerator = ApplicationTest.TestNumberGenerator(listOf(1, 0, 0))
        val bridgeMaker = BridgeMaker(numberGenerator)
        val bridge: List<String> = bridgeMaker.makeBridge(3)
        Assertions.assertThat(bridge).containsExactly("U", "D", "D")
    }*/

    @Test
    fun `기능 테스트`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest({
            run("3", "U", "U", "R", "U", "D", "D")
            Assertions.assertThat(output()).contains(
                "최종 게임 결과",
                "[ O |   |   ]",
                "[   | O | O ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 2"
            )
            val upSideIndex = output().indexOf("[ O |   |   ]")
            val downSideIndex = output().indexOf("[   | O | O ]")
            Assertions.assertThat(upSideIndex).isLessThan(downSideIndex)
        }, 1, 0, 0)
    }

    /*@Test
    fun `이동할 칸 입력 단위 테스트`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest(
            {
                run("3", "U", "U", "U")
                Assertions.assertThat(output()).contains(
                    "3",
                    "U",
                    "U",
                    "U",
                )
            },
            listOf(1, 1, 1),
        )
    }*/


    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }

}