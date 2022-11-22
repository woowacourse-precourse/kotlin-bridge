package bridge.view

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BridgeSizeCheckerTest {
    @Test
    fun `다리 길이가 알파벳이면 예외 처리`() {
        val result = BridgeSizeChecker("a").checkAll()
        assertThat(result).isEqualTo(true)
    }

    @Test
    fun `다리 길이가 알파벳과 숫자가 섞여있으면 예외 처리`() {
        val result = BridgeSizeChecker("a1").checkAll()
        assertThat(result).isEqualTo(true)
    }

    @Test
    fun `다리 길이가 기호이면 예외 처리`() {
        val result = BridgeSizeChecker("!").checkAll()
        assertThat(result).isEqualTo(true)
    }

    @Test
    fun `다리 길이가 3 이상 20 이하의 숫자가 아니면 예외 처리`() {
        val result = BridgeSizeChecker("0").checkAll()
        assertThat(result).isEqualTo(true)
    }

    @Test
    fun `다리 길이가 정상일 경우`() {
        val result = BridgeSizeChecker("8").checkAll()
        assertThat(result).isEqualTo(false)
    }
}