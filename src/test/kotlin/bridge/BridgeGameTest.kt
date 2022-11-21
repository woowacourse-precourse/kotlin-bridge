package bridge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName

internal class BridgeGameTest {

    @DisplayName("입력한 값에 따라 다리 상태를 나타낸다")
    @Test
    fun move() {
        assertEquals(
            "[[O] | [ ]]",
            BridgeGame().move("U", "U")
                .joinToString(" | ", "[", "]")
        )
    }

    @DisplayName("입력한 값에 따라 재시작 여부를 판별한다")
    @Test
    fun retry() {
        assertEquals(
            true, BridgeGame().retry("R")
        )
    }
}