package bridge

import org.assertj.core.api.Assertions.assertThat
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test

class OutputViewTest : NsTest(){
    @Test
    fun `게임 시작 문구 출력 테스트`() {
        assertSimpleTest{
            OutputView().printGameStartMessage()
            assertThat(output()).contains("다리 건너기 게임을 시작합니다.")
        }
    }

    override fun runMain() {
        main()
    }
}