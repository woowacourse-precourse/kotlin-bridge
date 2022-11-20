package bridge.controller

import bridge.view.OutputView
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ValidatorControllerTest {
    private lateinit var controller: ValidatorController
    private lateinit var outputView: OutputView

    @BeforeEach
    fun setUp() {
        outputView = OutputView()
        controller = ValidatorController(outputView)
    }

    @ParameterizedTest
    @ValueSource(strings = ["3", "10", "20"])
    fun `다리 길이가 유효하면 참이다`(input: String) {
        assertThat(controller.validateBridgeSize(input)).isTrue
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "2", "21", "", " ", "a"])
    fun `다리 길이가 유효하지 않으면 거짓이다`(input: String) {
        assertThat(controller.validateBridgeSize(input)).isFalse
    }
}