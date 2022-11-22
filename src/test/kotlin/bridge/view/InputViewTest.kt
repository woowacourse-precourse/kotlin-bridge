package bridge.view

import bridge.exceptions.InputExceptions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class InputViewTest {

    @DisplayName("다리 사이즈를 입력할 때 예외처리가 잘되는지 확인")
    @ParameterizedTest
    @ValueSource(strings = ["123", "d", "삼","","2","-1","21"])
    fun readBridgeSize(input : String) {
        assertThrows<IllegalArgumentException> {
            InputExceptions.validateBridgeSize(input)
        }
    }

    @DisplayName("어느 다리로 이동할지 입력할 때 예외처리가 잘되는지 확인")
    @ParameterizedTest
    @ValueSource(strings = ["u", "d", "위","","UD"])
    fun readMoving(input : String) {
        assertThrows<IllegalArgumentException> {
            InputExceptions.validateInputMove(input)
        }
    }

    @DisplayName("재시작을 하려고 입력할 때 예외처리가 잘되는지 확인")
    @ParameterizedTest
    @ValueSource(strings = ["r", "q", "종료","재시작","R ", "Rq", "RQ",""])
    fun readGameCommand(input : String) {
        assertThrows<IllegalArgumentException> {
            InputExceptions.validateInputRestart(input)
        }
    }

}