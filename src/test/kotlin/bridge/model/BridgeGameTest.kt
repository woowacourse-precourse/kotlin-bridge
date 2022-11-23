package bridge.model

import bridge.main
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class BridgeGameTest: NsTest() {

    private val bridgeBoard = BridgeBoard()
    private val goalList = listOf<String>("U", "D")

    @Test
    fun `move Test`(){
        val bridgeGame = BridgeGame(goalList, bridgeBoard)
        bridgeGame.move("U")
        bridgeGame.move("D")

        assertThat(bridgeBoard.board).containsExactly(mutableListOf("O"," "), mutableListOf(" ","O"))
    }

    @Test
    fun `retry Test`(){
        val bridgeGame = BridgeGame(goalList, bridgeBoard)
        bridgeGame.move("U")
        bridgeGame.move("D")
        bridgeGame.retry(bridgeBoard)

        assertThat(bridgeGame.attempts).isEqualTo(2)
    }



    override fun runMain() {
        main()
    }
}