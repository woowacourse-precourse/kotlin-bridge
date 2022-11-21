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
    val movings = listOf<String>("U", "U", "U")
    val maps = listOf<String>(
        "[ O ]\n[   ]", "[ O | O ]\n" +
                "[   |   ]", "[ O | O | X ]\n" +
                "[   |   |   ]"
    )

    @BeforeEach
    fun setUp() {
        bridge = Bridge(listOf("U", "U", "D"))
        bridgeGame = BridgeGame()
    }

    @DisplayName("유저가 이동한 후에 게임 결과를 반환하는지 확인하는 Domain 테스트")
    @ParameterizedTest
    @CsvSource("U,U,D,continue,continue,success", "U,U,U,continue,continue,fail", "D,D,D,fail,fail,fail")
    fun getGameResult(
        moving1: String,
        moving2: String,
        moving3: String,
        result1: String,
        result2: String,
        result3: String,
    ) {
        val movings = listOf<String>(moving1, moving2, moving3)
        val results = listOf(result1, result2, result3)
        for (i in movings.indices) {
            val moving = movings[i]
            val result = results[i]
            bridgeGame.move(moving, user)
            val actual = bridgeGame.getGameResult(bridge, user)
            val expected = convertStringToGameResult(result)
            assertThat(actual).isEqualTo(expected)
        }
    }

    @DisplayName("유저가 이동한 후에 map을 잘 반환하는지 확인하는 테스트")
    @Test
    fun getMap(){
        for (i in movings.indices){
            val moving = movings[i]
            val expected = maps[i]
            bridgeGame.move(moving, user)
            bridgeGame.getGameResult(bridge, user)
            val actual = bridgeGame.getMap(user.movingResults)
            assertThat(actual).isEqualTo(expected)
        }
    }


    private fun convertStringToGameResult(result: String): BridgeGame.GameResult {
        return when (result) {
            "success" -> BridgeGame.GameResult.SUCCESS
            "fail" -> BridgeGame.GameResult.FAILURE
            "continue" -> BridgeGame.GameResult.CONTINUE
            else -> BridgeGame.GameResult.CONTINUE
        }
    }
}