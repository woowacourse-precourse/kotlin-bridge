package bridge

import bridge.ui.OutputView
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class OutputViewTest: NsTest(){
    private val outputView = OutputView()
    @Test
    fun `다리 건너기 성공 출력 테스트`(){
        outputView.printMap(playerMove1)
        assertThat(output()).contains("[ O |   | O ]", "[   | O |   ]")
    }

    @Test
    fun `다리 건너기 실패 출력 테스트`(){
        outputView.printMap(playerMove2)
        assertThat(output()).contains("[ O |   ]", "[   | X ]")
    }

    @Test
    fun `게임 실행 0회 예외 테스트`(){
        outputView.printStats(NO_GAME, SUCCESS)
        assertThat(output()).contains(ERROR_MESSAGE)
    }

    override fun runMain() {
        main()
    }

    companion object{
        private const val ERROR_MESSAGE = "[ERROR] "
        private val playerMove1 = mutableListOf(listOf("O"," "),listOf(" ","O"),listOf("O"," "))
        private val playerMove2 = mutableListOf(listOf("O"," "),listOf(" ","X"))
        private const val NO_GAME = 0
        private const val SUCCESS = "성공"
    }
}