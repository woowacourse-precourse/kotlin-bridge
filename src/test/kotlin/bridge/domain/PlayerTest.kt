package bridge.domain

import bridge.ApplicationTest
import bridge.util.BridgeNumberGenerator
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class PlayerTest {

    @BeforeEach
    fun setUp() {
        val numberGenerator: BridgeNumberGenerator = ApplicationTest.TestNumberGenerator(listOf(1, 0, 0))
        val bridgeMaker = BridgeMaker(numberGenerator)
        bridge = bridgeMaker.makeBridge(3)
    }

    @ParameterizedTest
    @CsvSource("U,0,true", "D,1,true", "U,2,false")
    @DisplayName("이동할 명령어대로 이동하고, 기록을 잘하는 지 확인 및 다리 칸이랑 비교")
    fun `플레이어가_지나간_칸과_다리_비교_확인`(move: String, index: Int, flag: Boolean) {
        val player = Player()
        player.go(move)
        println(player.getState())
        Assertions.assertThat(bridge[index] == player.getState()[index]).isEqualTo(flag)
    }

    companion object {
        private lateinit var bridge: List<String>
    }
}
