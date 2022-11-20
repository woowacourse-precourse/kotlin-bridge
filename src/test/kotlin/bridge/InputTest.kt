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

    @Test
    fun `이동할 칸이 U 또는 D가 아닐 경우`() {
        assertThrows<IllegalArgumentException> {
            inputTest.checkMoveDirection("L")
        }
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}