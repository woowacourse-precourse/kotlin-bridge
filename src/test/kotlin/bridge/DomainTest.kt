package bridge

import bridge.domain.Bridge
import bridge.domain.BridgeGame
import bridge.domain.User
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class DomainTest {

    private lateinit var bridge: Bridge
    private lateinit var bridgeGame: BridgeGame
    private var user = User()
    private val movings = listOf<String>("U", "U", "U")
    private val results =
        listOf(BridgeGame.GameResult.CONTINUE, BridgeGame.GameResult.CONTINUE, BridgeGame.GameResult.FAILURE)
    private val maps = listOf<String>(
        "[ O ]\n[   ]", "[ O | O ]\n" +
                "[   |   ]", "[ O | O | X ]\n" +
                "[   |   |   ]"
    )

    @BeforeEach
    fun setUp() {
        bridge = Bridge(listOf("U", "U", "D"))
        bridgeGame = BridgeGame()
    }

    @Test
    fun `유저가 이동한 후에 게임 결과를 옳게 반환하는지 확인하는 Domain 테스트`() {
        for (i in movings.indices) {
            val moving = movings[i]
            val expected = results[i]
            bridgeGame.move(moving, user)
            val actual = bridgeGame.getGameResult(bridge, user)
            assertThat(actual).isEqualTo(expected)
        }
    }

    @DisplayName("유저가 이동한 후에 map을 잘 반환하는지 확인하는 테스트")
    @Test
    fun `유저가 이동한 후에 map을 잘 반환하는지 확인하는 테스트`() {
        for (i in movings.indices) {
            val moving = movings[i]
            val expected = maps[i]
            bridgeGame.move(moving, user)
            bridgeGame.getGameResult(bridge, user)
            val actual = bridgeGame.getMap(user.movingResults)
            assertThat(actual).isEqualTo(expected)
        }
    }
}