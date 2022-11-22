package bridge.domain

import bridge.BridgeGameStatus
import bridge.MovementStatus
import bridge.model.BridgeDTO
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class BridgeGameTest {
    private val bridge = listOf("U", "D", "D")
    private val bridgeDTO = BridgeDTO(bridge)
    private lateinit var bridgeGame: BridgeGame
    private val movementStatuses = listOf(MovementStatus.UP_RIGHT, MovementStatus.DOWN_RIGHT, MovementStatus.DOWN_RIGHT)

    @BeforeEach
    fun setUp() {
        bridgeGame = BridgeGame()
        bridgeGame.setBridge(bridgeDTO)
    }

    @ParameterizedTest
    @CsvSource("U,CONTINUE,UP_RIGHT", "D,FAILURE,DOWN_WRONG")
    fun `게임 상태 계속과 실패 테스트`(
        movement: String,
        expectedGameStatus: BridgeGameStatus,
        expectedMovementStatus: MovementStatus
    ) {
        val metadataDTO = bridgeGame.move(movement)
        assertThat(metadataDTO.getGameStatus()).isEqualTo(expectedGameStatus)
        assertThat(metadataDTO.getMovementStatuses().first()).isEqualTo(expectedMovementStatus)
    }

    @Test
    fun `게임 상태 성공 테스트`() {
        val metadataDTOs = bridge.map { movement -> bridgeGame.move(movement) }
        val finalMetadataDTO = metadataDTOs.last()

        assertThat(finalMetadataDTO.getGameStatus()).isEqualTo(BridgeGameStatus.SUCCESS)
        assertThat(finalMetadataDTO.getMovementStatuses()).isEqualTo(movementStatuses)
        assertThat(finalMetadataDTO.getTrialCount()).isEqualTo(1)
    }

    @Test
    fun `게임 재시작 후 성공`() {
        val firstTrialMovements = listOf("U", "U")

        firstTrialMovements.map { movement -> bridgeGame.move(movement) }
        bridgeGame.retry()
        val metadataDTOs = bridge.map { movement -> bridgeGame.move(movement) }
        val finalMetadataDTO = metadataDTOs.last()

        assertThat(finalMetadataDTO.getGameStatus()).isEqualTo(BridgeGameStatus.SUCCESS)
        assertThat(finalMetadataDTO.getMovementStatuses()).isEqualTo(movementStatuses)
        assertThat(finalMetadataDTO.getTrialCount()).isEqualTo(2)
    }
}