package bridge

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class OutputTest {
    @Test
    fun `경로 출력 테스트1`() {
        val bridge= Bridge(mutableListOf<String>("U","D","D"))
        val answer= listOf<String>("U","D","U")
        OutputView().printMap( bridge.makeUpStep(answer),bridge.makeDownStep(answer))
        println()

    }
    @Test
    fun `경로 출력 테스트2`() {
        val bridge= Bridge(mutableListOf<String>("U"))
        val answer= listOf<String>("D","U","U")
        OutputView().printMap( bridge.makeUpStep(answer),bridge.makeDownStep(answer))
        println()
    }
    @Test
    fun `경로 출력 테스트3`() {
        val bridge= Bridge(mutableListOf<String>("U","D","D"))
        val answer= listOf<String>("U","D","D")
        OutputView().printMap( bridge.makeUpStep(answer),bridge.makeDownStep(answer))
        println()

    }
    @Test
    fun `경로 출력 테스트4`() {
        val bridge= Bridge(mutableListOf<String>("U","U","U"))
        val answer= listOf<String>("U","U","U","U","D")
        OutputView().printMap( bridge.makeUpStep(answer),bridge.makeDownStep(answer))
        println()
    }

    @Test
    fun `성공 시 결과 출력 테스트`(){
        val bridge= Bridge(mutableListOf<String>("U","D","D"))
        val answer= mutableListOf<String>("U","D","D")
        val game=BridgeGame(answer,Bridge(answer),Status(1,"성공"))
        game.showResult()
    }


}