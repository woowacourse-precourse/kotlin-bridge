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

    @ParameterizedTest
    @ValueSource(strings = ["U", "D"])
    fun `이동할 칸이 유효하면 참이다`(input: String) {
        assertThat(controller.validateMovement(input)).isTrue
    }

    @ParameterizedTest
    @ValueSource(strings = ["u", "d", "a", "", " ", "R", "Q", "UU", "DD"])
    fun `이동할 칸이 유효하지 않으면 거짓이다`(input: String) {
        assertThat(controller.validateMovement(input)).isFalse
    }

    @ParameterizedTest
    @ValueSource(strings = ["R", "Q"])
    fun `명령어가 유효하면 참이다`(input: String) {
        assertThat(controller.validateGameCommand(input)).isTrue
    }

    @ParameterizedTest
    @ValueSource(strings = ["r", "q", "a", "", " ", "U", "D", "RR", "QQ"])
    fun `명령어가 유효하지 않으면 거짓이다`(input: String) {
        assertThat(controller.validateGameCommand(input)).isFalse
    }
}