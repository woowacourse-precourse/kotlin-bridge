package bridge.domain

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.BeforeEach

internal class BridgeCheckerTest {
    private lateinit var bridgeChecker: BridgeChecker
    private lateinit var bridge: List<String>

    @BeforeEach
    fun setUp() {
        bridge = listOf("U", "U", "D")
        bridgeChecker = BridgeChecker(bridge)
    }

    @Test
    fun `사용자의 입력값과 실제 건널 수 있는 다리의 칸이 같은 값인지 검사한다`() {

    }
}