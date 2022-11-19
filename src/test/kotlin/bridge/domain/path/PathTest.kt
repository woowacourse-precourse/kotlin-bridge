package bridge.domain.path

import bridge.util.constant.DOWN_INDEX
import bridge.util.constant.UP_INDEX
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class PathTest {

    lateinit var playerPath: Path

    @BeforeEach
    fun setUp() {
        playerPath = Path(listOf("U", "U", "D"))
    }

    @DisplayName("플레이어 이동 경로에 D를 추가한 경우")
    @Test
    fun `경로를 추가하면 새롭게 추가된 경로 객체를 반환한다`() {
        playerPath = playerPath.add("D")
        val lastIndex = playerPath.position()
        val expectedResult = playerPath.checkDirection("D", lastIndex)

        assertEquals(expectedResult, true)
    }

    @DisplayName("플레이어 이동 경로 초기화")
    @Test
    fun `플레이어 이동 경로를 초기화하면 새로운 초기화된 객체를 반환한다`() {
        val initializedPath = playerPath.init()
        val expectedSize = initializedPath.position() + 1

        assertEquals(expectedSize, 0)
    }

    @DisplayName("특정 라운드의 경로 반환")
    @ParameterizedTest
    @CsvSource(
        "0, U",
        "1, U",
        "2, D"
    )
    fun `특정 라운드의 플레이어 이동 경로를 반환한다`(round: Int, direction: String) {
        val expectedDirection = playerPath.userDirectionOf(round)
        assertEquals(expectedDirection, direction)
    }

    @DisplayName("특정 라운드의 경로를 숫자로 반환")
    @ParameterizedTest
    @CsvSource(
        "0, $UP_INDEX",
        "1, $UP_INDEX",
        "2, $DOWN_INDEX"
    )
    fun `특정 라운드의 플레이어 이동 경로를 숫자로 반환한다`(round: Int, directionIndex: Int) {
        val expectedDirection = playerPath.userDirectionAsDigit(round)
        assertEquals(expectedDirection, directionIndex)
    }
}