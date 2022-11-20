package bridge

import bridge.domain.InputCheck
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputTest : NsTest() {

    private val inputTest = InputCheck()

    @Test
    fun `다리 길이가 숫자인지 확인한다`() {
        assertThrows<IllegalArgumentException> {
            inputTest.checkBridgeSize("a1")
        }
    }

    @Test
    fun `다리 길이가 3~20인지 확인한다`() {
        assertThrows<IllegalArgumentException> {
            inputTest.checkBridgeSize("21")
        }
    }

    @Test
    fun `다리 길이가 int보다 큰지 확인한다`() {
        assertThrows<IllegalArgumentException> {
            inputTest.checkBridgeSize("12311234123124213124")
        }
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}