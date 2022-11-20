package bridge

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class BridgeGameTest {
    private var bridgeGame = BridgeGame()

    @BeforeEach
    fun setUp(){
        CorrectBridge.correctBridge= mutableListOf("U","U","D","U")
        bridgeGame = BridgeGame()
    }

    @Test
    fun `이동 실패시 게임 오버 테스트`(){
        bridgeGame.move("D")
        val result = bridgeGame.checkGameOver()
        assertThat(result).isEqualTo(true)
    }

    @Test
    fun `이동 성공시 게임 오버 테스트`(){
        bridgeGame.move("U")
        val result = bridgeGame.checkGameOver()
        assertThat(result).isEqualTo(false)
    }

    @Test
    fun `이동 테스트`(){
        repeatMove(listOf("U","U","D"))
        assertThat(bridgeGame.currentMoving).isEqualTo(listOf("U","U","D"))
    }

    @Test
    fun `게임 성공 테스트`(){
        repeatMove(listOf("U","U","D","U"))
        val result = bridgeGame.checkGameWin()
        assertThat(result).isEqualTo(true)
    }

    @Test
    fun `게임 실패 테스트`(){
        repeatMove(listOf("U","U","D","D"))
        val result = bridgeGame.checkGameWin()
        assertThat(result).isEqualTo(false)
    }

    @Test
    fun `재시작 테스트`(){
        bridgeGame.retry()
        assertThat(bridgeGame.tryCount).isEqualTo(1)
        assertThat(bridgeGame.currentMoving.size).isEqualTo(0)
    }

    fun repeatMove(movings : List<String>){
        for(moving in movings){
            bridgeGame.move(moving)
        }
    }
}