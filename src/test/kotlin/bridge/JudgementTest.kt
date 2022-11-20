package bridge

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import java.util.NoSuchElementException

class JudgementTest {
    private val judgement = Judgement()

    @BeforeEach
    fun setUp(){
        CorrectBridge.correctBridge= mutableListOf("U","U","D","U")
    }

    @Test
    fun `이동 성공 테스트`(){
        val result = judgement.judgeMovingSuccess(listOf("U"))
        assertThat(result).isEqualTo(true)
    }

    @Test
    fun `이동 실패 테스트`(){
        val result = judgement.judgeMovingSuccess(listOf("D"))
        assertThat(result).isEqualTo(false)
    }

    @Test
    fun `다리를 모두 통과하여 게임 오버가 맞는지 테스트`(){
        val result = judgement.checkGameOver(listOf("U","U","D","U"))
        assertThat(result).isEqualTo(true)
    }

    @Test
    fun `다리를 잘못 건너서 게임 오버가 맞는지 테스트`(){
        val result = judgement.checkGameOver(listOf("U","U","D","D"))
        assertThat(result).isEqualTo(true)
    }

    @Test
    fun `게임을 다 건너지 않아서 게임 오버가 아님을 테스트`(){
        val result = judgement.checkGameOver(listOf("U","U","D"))
        assertThat(result).isEqualTo(false)
    }

    @Test
    fun `게임 승리 테스트`(){
        val result = judgement.checkGameWin(listOf("U","U","D","U"))
        assertThat(result).isEqualTo(true)
    }

    @Test
    fun `게임 실패 테스트`(){
        val result = judgement.checkGameWin(listOf("U","U","D","D"))
        assertThat(result).isEqualTo(false)
    }

    @Test
    fun `정답 다리 추가시 사이즈가 맞는지 테스트`(){
        judgement.createBridge(3)
        assertThat(CorrectBridge.correctBridge.size).isEqualTo(3)
    }
}