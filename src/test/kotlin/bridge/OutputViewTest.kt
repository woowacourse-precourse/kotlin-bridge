package bridge

import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class OutputViewTest: NsTest() {
    @Test
    fun `다리 건너기 결과의 출력 테스트`() {
        val bridgeGame = BridgeGame(listOf("U", "D", "U", "U", "U"))
        bridgeGame.move("U")
        bridgeGame.move("D")
        bridgeGame.move("U")
        OutputView().printMap(bridgeGame)
        assertThat(output()).contains(
            "[ O |   | O ]",
            "[   | O |   ]",
        )
    }
    override fun runMain() {
        TODO("Not yet implemented")
    }
}