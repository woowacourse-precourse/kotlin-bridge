package bridge.domain

import bridge.ApplicationTest
import bridge.BridgeNumberGenerator
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class PlayerTest {

    private lateinit var numberGenerator: BridgeNumberGenerator
    private lateinit var bridgeGame: BridgeGame

    @BeforeEach
    fun setUp() {
        numberGenerator = ApplicationTest.TestNumberGenerator(listOf(1, 0, 0))
        bridgeGame = BridgeGame(numberGenerator, 3, player)
    }

    @ParameterizedTest
    @CsvSource("U,0,true", "D,1,true", "U,2,false")
    @DisplayName("이동할 명령어대로 이동하고, 기록을 잘하는 지 확인 및 다리 칸이랑 비교")
    fun `플레이어가_지나간_칸과_다리_비교_확인`(move: String, index: Int, flag: Boolean) {

        player.go(move)
        Assertions.assertThat(bridgeGame.getBridge()[index] == player.getRecord()[index]).isEqualTo(flag)
    }

    companion object {
        private val player = Player()
    }
}
