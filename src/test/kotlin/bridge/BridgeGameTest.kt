package bridge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BridgeGameTest {
    private val bridgeGame = BridgeGame()

    @Test
    fun `이동한 맵을 위, 아래 각각 하나의 리스트로 변환한다`() {
        val upMap = BridgeGame.UP to UP_LIST
        val downMap = BridgeGame.DOWN to DOWN_LIST
        val movingList = mapOf(upMap, downMap)
        val upList = bridgeGame.separateList(movingList, BridgeGame.UP)
        val downList = bridgeGame.separateList(movingList, BridgeGame.DOWN)

        assertThat(upList).isEqualTo(UP_LIST)
        assertThat(downList).isEqualTo(DOWN_LIST)
    }

    @Test
    fun `이동한 칸이 생성된 다리 위치의 값과 같으면 O, 다르면 X, 그 외는 빈칸을 추가하여 이동한 맵을 반환한다`() {
        val map = bridgeGame.move("U", listOf("U", "D", "U"))

        assertThat(map).isEqualTo(mapOf(BridgeGame.UP to listOf("O"), BridgeGame.DOWN to listOf(" ")))
    }

    @Test
    fun `위, 아래 리스트를 출력 형식에 맞게 반환한다`() {
        val upList = bridgeGame.transformedList(UP_LIST)
        val downList = bridgeGame.transformedList(DOWN_LIST)

        assertThat(upList).isEqualTo("[   |   | O ]")
        assertThat(downList).isEqualTo("[ O | O |   ]")
    }

    companion object {
        val UP_LIST = listOf(" ", " ", "O")
        val DOWN_LIST = listOf("O", "O", " ")
    }
}