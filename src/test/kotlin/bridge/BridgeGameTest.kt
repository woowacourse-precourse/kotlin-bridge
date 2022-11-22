package bridge

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.*
import java.lang.IllegalArgumentException

internal class BridgeGameTest {

    @Test
    fun `기능테스트(move)`() {
        val move = "U"
        val bridge = mutableListOf<String>("U", "D")
        val answer = mutableListOf<String>("U", "D", "U")
        assertEquals(answer, BridgeGame().move(move, bridge))
    }

    @Test
    fun `기능테스트(isRight)`() {
        val nowBridge = mutableListOf<String>("U", "D", "U")
        val bridge = listOf<String>("U", "D", "U")
        assertEquals(true, BridgeGame().isRight(bridge, nowBridge))

        val nowBridge1 = mutableListOf<String>("U", "D")
        val bridge1 = listOf<String>("U", "D", "U")
        assertEquals(true, BridgeGame().isRight(bridge1, nowBridge1))

        val nowBridge2 = mutableListOf<String>("U", "U")
        val bridge2 = listOf<String>("U", "D", "U")
        assertEquals(false, BridgeGame().isRight(bridge2, nowBridge2))
    }

    @Test
    fun `기능테스트(retry)`() {
        val command = "R"
        assertEquals(false, BridgeGame().retry(command))

        val command1 = "Q"
        assertEquals(true, BridgeGame().retry(command1))
    }

    @Test
    fun `예외테스트(retry)`() {
        val command = "U"
        assertThrows<IllegalArgumentException> {
            BridgeGame().retry(command)
        }
    }
}