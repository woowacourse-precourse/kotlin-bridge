package bridge

import bridge.utils.ExceptionHandler
import bridge.view.InputView
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.Exception

class InputExceptionTest {

    @Test
    fun `다리 사이즈로 숫자 이외의 값이 들어갔을 때 예외가 발생한다`(){
        assertThrows<IllegalArgumentException> {ExceptionHandler.validateIntType("d")}
    }

    @Test
    fun `다리 사이즈로 3 ~ 20 이외의 숫자가 들어갔을 때 예외가 발생한다`(){
        assertThrows<IllegalArgumentException> {ExceptionHandler.validateInRange(21)}
    }

    @Test
    fun `이동할 칸으로 U 또는 D 이외의 값이 들어갔을 때 예외가 발생한다`(){
        assertThrows<IllegalArgumentException> {ExceptionHandler.validateMoveLaneSymbol("u")}
    }

    @Test
    fun `재시도 여부로 R 또는 Q 이외의 값이 들어갔을 때 예외가 발생한다`(){
        assertThrows<IllegalArgumentException> {ExceptionHandler.validateRetrialSymbol("q")}
    }


}