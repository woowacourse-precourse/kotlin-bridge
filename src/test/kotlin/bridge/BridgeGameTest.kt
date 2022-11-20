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


//    @Test
//    fun `다리 생성시 사이즈 테스트`(){
//
//    }
}