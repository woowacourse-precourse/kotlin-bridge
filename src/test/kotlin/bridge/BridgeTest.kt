package bridge

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat

class BridgeTest {

    @Test
    fun `입력 값에 따라 다리 이동 가능한지 알 수 있는 기능 테스트`() {

        val bridge = listOf<String>("U","U","P")
        val userDirection = "U"
        val result =  BridgeGame().move(userDirection, bridge, 0)
        val resultMap = mutableMapOf<String, String>()
        resultMap["U"] = "O"
        assertThat(result).isEqualTo(resultMap)
    }

}