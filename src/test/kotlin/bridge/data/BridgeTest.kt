package bridge.data

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BridgeTest {
    val bridge = Bridge(listOf("U", "D", "D"))

    @Test
    fun `matchTest`() {
        val result = "O"
        assertThat(result).isEqualTo(bridge.match("U"))
    }
    @Test
    fun  `finishTest_마지막 다리가 아닐때_false 반환`(){
        val result = false
        assertThat(result).isEqualTo(bridge.finish("U"))
    }
}
