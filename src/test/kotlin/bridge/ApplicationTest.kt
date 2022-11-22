package bridge

import bridge.constant.*
import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ApplicationTest : NsTest() {

    @Test
    fun `게임 종료 check 하는 함수 test`(){
        val numberGenerator: BridgeNumberGenerator = TestNumberGenerator(listOf(1, 0, 0))
        val bridgeMaker = BridgeMaker(numberGenerator)
        val bridge= Bridge(bridgeMaker.makeBridge(3))

        bridge.movePlayer(UP_SIDE)
        bridge.movePlayer(DOWN_SIDE)
        bridge.movePlayer(DOWN_SIDE)

        assertThat(bridge.checkGameEnd()).isEqualTo(END)
    }
    @Test
    fun `이동이 틀렸을 때 check 하는 함수 test`(){
        val numberGenerator: BridgeNumberGenerator = TestNumberGenerator(listOf(1, 0, 0))
        val bridgeMaker = BridgeMaker(numberGenerator)
        val bridge= Bridge(bridgeMaker.makeBridge(3))

        bridge.movePlayer(DOWN_SIDE)

        assertThat(bridge.checkGameEnd()).isEqualTo(WRONG)
    }
    @Test
    fun `다리 상태 생성 test`(){
        val numberGenerator: BridgeNumberGenerator = TestNumberGenerator(listOf(1, 0, 0))
        val bridgeMaker = BridgeMaker(numberGenerator)
        val bridge: Bridge= Bridge(bridgeMaker.makeBridge(3))

        bridge.movePlayer(UP_SIDE)
        bridge.movePlayer(DOWN_SIDE)
        val expect= listOf(listOf("O"," "), listOf(" ","O"))
        assertThat(bridge.getRoadUntilNow().getRoadMap()[0]).isEqualTo(expect[0])
        assertThat(bridge.getRoadUntilNow().getRoadMap()[1]).isEqualTo(expect[1])
    }
    @Test
    fun `다리 생성 테스트`() {
        val numberGenerator: BridgeNumberGenerator = TestNumberGenerator(listOf(1, 0, 0))
        val bridgeMaker = BridgeMaker(numberGenerator)
        val bridge: List<String> = bridgeMaker.makeBridge(3)
        assertThat(bridge).containsExactly("U", "D", "D")
    }

    @Test
    fun `게임 reset 테스트`(){
        val numberGenerator: BridgeNumberGenerator = TestNumberGenerator(listOf(1, 0, 0))
        val bridgeMaker = BridgeMaker(numberGenerator)
        val bridge= Bridge(bridgeMaker.makeBridge(3))
        val bridgeGame=BridgeGame()

        bridge.movePlayer(UP_SIDE)
        bridge.movePlayer(DOWN_SIDE)

        bridgeGame.retry(bridge)

        assertThat(bridge.getRoadUntilNow().getRoadMap()[0].size).isEqualTo(0)
    }
    @Test
    fun `기능 테스트`() {
        assertRandomNumberInRangeTest({
            run("3", "U", "D", "U")
            assertThat(output()).contains(
                "최종 게임 결과",
                "[ O |   | O ]",
                "[   | O |   ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 1"
            )
            val upSideIndex = output().indexOf("[ O |   | O ]")
            val downSideIndex = output().indexOf("[   | O |   ]")
            assertThat(upSideIndex).isLessThan(downSideIndex)
        }, 1, 0, 1)
    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            runException("a")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    override fun runMain() {
        main()
    }

    class TestNumberGenerator(numbers: List<Int>) : BridgeNumberGenerator {
        private val numbers: MutableList<Int> = numbers.toMutableList()

        override fun generate(): Int {
            return numbers.removeAt(0)
        }
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}
