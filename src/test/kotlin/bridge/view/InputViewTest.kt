package bridge.view

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class InputViewTest : NsTest() {

    @ParameterizedTest
    @ValueSource(strings = ["3", "10", "20"])
    fun `다리길이입력_3to20숫자_정상`(input: String) {
        assertSimpleTest {
            run(input)
            InputView.readBridgeSize()
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["3a", ".5", "1,3", "1.2"])
    fun `다리길이입력_문자포함_에러`(input: String) {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException(input)
                InputView.readBridgeSize()
            }
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "0", "2", "21", "100"])
    fun `다리길이입력_벗어난범위_에러`(input: String) {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException(input)
                InputView.readBridgeSize()
            }
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["U", "D"])
    fun `이동할칸입력_UorD_정상`(input: String) {
        assertSimpleTest {
            run(input)
            InputView.readNextFloor()
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["u", "d", "R", "Q", "1", "UD"])
    fun `이동할칸입력_notUorD_에러`(input: String) {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException(input)
                InputView.readNextFloor()
            }
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["R", "Q"])
    fun `게임재시작종료입력_RorQ_정상`(input: String) {
        assertSimpleTest {
            run(input)
            InputView.askRetryGame()
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["U", "D", "r", "q", "RQ"])
    fun `게임재시작종료입력_notRorQ_에러`(input: String) {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException(input)
                InputView.askRetryGame()
            }
        }
    }

    override fun runMain() {}
}
