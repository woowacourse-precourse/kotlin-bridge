package bridge.view

import bridge.model.GameState
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
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
                Arguments.of(GameState(listOf("U", "D", "D"), listOf("U", "D", "D")), "[ O |   |   ]\n[   | O | O ]"),
                Arguments.of(GameState(listOf("U", "D", "D"), listOf("U", "D", "U")), "[ O |   | X ]\n[   | O |   ]")
            )

            @ParameterizedTest
            @MethodSource("gameStates")
            fun `사용자가 지나온 길을 보여준다`(gameState: GameState, result: String) {
                outputView.notify(gameState)

                assertThat(output()).isEqualTo(result)
            }

            override fun runMain() {

            }
        }
    }
}