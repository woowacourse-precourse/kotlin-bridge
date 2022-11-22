package bridge

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BridgeGameTest : NsTest() {
    private lateinit var bridgeGame: BridgeGame

    @BeforeEach
    fun makeBridgeGame() {
        bridgeGame = BridgeGame(listOf("U", "D", "D"))
    }

    @Test
    fun `이동 테스트 - 성공`() {
        Assertions.assertThat(
            bridgeGame.move("D", listOf("U"))
        ).containsExactly("U", "D")
    }

    @Test
    fun `이동 테스트 - 실패`() {
        Assertions.assertThat(
            bridgeGame.move("U", listOf("U"))
        ).containsExactly("U", "UX")
    }

    @Test
    fun `O인지 X인지 테스트 - O인 경우`() {
        Assertions.assertThat(
            bridgeGame.checkOX(listOf("U", "D"))
        ).containsExactly("U", "D")
    }

    @Test
    fun `O인지 X인지 테스트 - X인 경우`() {
        Assertions.assertThat(
            bridgeGame.checkOX(listOf("U", "U"))
        ).containsExactly("U", "UX")
    }

    @Test
    fun `틀린 경우 X 붙이기 테스트`() {
        Assertions.assertThat(
            bridgeGame.addX(listOf("U", "D", "U"), mutableListOf("U", "D", "U"))
        ).containsExactly("U", "D", "UX")
    }

    @Test
    fun `성공 여부 체크 테스트 - 성공`() {
        Assertions.assertThat(
            bridgeGame.checkSuccess(listOf("U", "D"))
        ).isTrue
    }

    @Test
    fun `성공 여부 체크 테스트 - 실패`() {
        Assertions.assertThat(
            bridgeGame.checkSuccess(listOf("U", "U"))
        ).isFalse
    }

    override fun runMain() {
        main()
    }
}