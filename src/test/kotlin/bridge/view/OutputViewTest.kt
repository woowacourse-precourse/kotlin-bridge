package bridge.view

import bridge.model.GameResult
import bridge.model.GameMapState
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class OutputViewTest {
    private val outputView = OutputView()

    @Nested
    inner class `notify 메소드는` {

        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        @Nested
        inner class `게임 상태를 받으면`: NsTest() {
            private fun gameStates() = listOf(
                Arguments.of(GameMapState(listOf("U", "D", "D"), listOf("U", "D", "D")), "[ O |   |   ]\n[   | O | O ]"),
                Arguments.of(GameMapState(listOf("U", "D", "D"), listOf("U", "D", "U")), "[ O |   | X ]\n[   | O |   ]")
            )

            @ParameterizedTest
            @MethodSource("gameStates")
            fun `사용자가 지나온 길을 보여준다`(gameMapState: GameMapState, result: String) {
                outputView.notify(gameMapState)

                assertThat(output()).isEqualTo(result)
            }

            override fun runMain() {

            }
        }

        @Nested
        inner class `게임 상태와 게임 결과를 받으면`: NsTest() {
            private val gameMapState = GameMapState(listOf("U", "D", "D"), listOf("U", "D", "D"))
            private val gameResult = GameResult(true, 1)

            @Test
            fun `최종 게임 상태와 게임 결과를 출력한다`() {
                outputView.notify(gameMapState, gameResult)

                assertThat(output()).contains("[ O |   |   ]\n[   | O | O ]", "성공", "1")
            }

            override fun runMain() {

            }
        }
    }
}