package bridge.domain.map

import bridge.domain.bridge.Bridge
import bridge.domain.path.Path
import bridge.util.constant.DOWN_INDEX
import bridge.util.constant.UP_INDEX
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RouteMapTest {

    private lateinit var bridge: Bridge
    private lateinit var routeMap: RouteMap
    private lateinit var playerPath: Path

    @BeforeEach
    fun setUp() {
        val upMarks = arrayListOf(Mark.CORRECT, Mark.CORRECT)
        val downMarks = arrayListOf(Mark.WRONG, Mark.WRONG)

        bridge = Bridge(listOf("U", "U", "D")) // 올바른 다리 경로
        routeMap = RouteMap(listOf(upMarks, downMarks))
        playerPath = Path(listOf("U", "U"))
    }

    @DisplayName("3번째 라운드에서 DOWN에 올바른 경로 추가한 경우")
    @Test
    fun `사용자가 올바른 경로로 이동한 경우 루트에 CORRECT 추가된다`() {
        playerPath = playerPath.add("D")
        val playerRoute = routeMap.addPath(playerPath, bridge)

        assertThat(playerRoute[UP_INDEX]).containsExactly(Mark.CORRECT, Mark.CORRECT, Mark.DEFAULT)
        assertThat(playerRoute[DOWN_INDEX]).containsExactly(Mark.WRONG, Mark.WRONG, Mark.CORRECT)
    }


    @DisplayName("3번째 라운드에서 UP에 잘못된 경로 추가한 경우")
    @Test
    fun `사용자가 잘못된 경로로 이동한 경우 루트에 WRONG 추가된다`() {
        playerPath = playerPath.add("U")
        val playerRoute = routeMap.addPath(playerPath, bridge)

        assertThat(playerRoute[UP_INDEX]).containsExactly(Mark.CORRECT, Mark.CORRECT, Mark.WRONG)
        assertThat(playerRoute[DOWN_INDEX]).containsExactly(Mark.WRONG, Mark.WRONG, Mark.DEFAULT)
    }
}