package bridge

import bridge.game.Bridge
import bridge.io.InputView
import bridge.io.OutputView
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BridgeTest {



    @Test
    fun `makeTopRow 테스트`(){
        val bridge=Bridge(mutableListOf("U","D","D","U"),InputView(),OutputView())
        assertThat(bridge.makeTopRow(listOf("U","D","D","U","U"))).containsExactly("O"," "," ","O")
    }

    @Test
    fun `makeTopRow 테스트X`(){
        val bridge=Bridge(mutableListOf("U","D","D","U"),InputView(),OutputView())
        assertThat(bridge.makeTopRow(listOf("U","D","D","D","U"))).containsExactly("O"," "," ","X")
    }

    @Test
    fun `makeBotRow 테스트`(){
        val bridge=Bridge(mutableListOf("U","D","D","U"),InputView(),OutputView())
        assertThat(bridge.makeBotRow(listOf("U","D","D","U","U"))).containsExactly(" ","O","O"," ")
    }
    @Test
    fun `makeBotRow 테스트X`(){
        val bridge=Bridge(mutableListOf("U","D","D","D"),InputView(),OutputView())
        assertThat(bridge.makeBotRow(listOf("U","D","D","U","U"))).containsExactly(" ","O","O","X")
    }

    @Test
    fun `U D에 대한 입력값이 올바른 길인지 체크하는 함수 테스트 및 move함수 테스트`(){
        val bridge=Bridge(mutableListOf("U","D","D"),InputView(),OutputView())
        assertThat(bridge.move(mutableListOf("U","D","D","U"))).isTrue()
    }

    @Test
    fun `U D에 대한 입력값이 올바른 길인지 체크하는 함수 테스트 및 move 함수 테스트`(){
        val bridge=Bridge(mutableListOf("U","D","D",),InputView(),OutputView())
        assertThat(bridge.move(mutableListOf("U","D","U","U"))).isFalse()
    }
}