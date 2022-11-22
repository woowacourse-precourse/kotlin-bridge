package bridge

import bridge.model.BridgeGame
import bridge.model.data.Direction
import bridge.model.data.GameStatus
import bridge.model.data.PlayerStatus
import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BridgeGameTest {
    companion object{
        /**
         * 윗 방향으로만 이동 가능한 다리의 모양을 생성하기 위한 클래스
         */
        class BridgeUpNumberGenerator : BridgeNumberGenerator {
            override fun generate(): Int {
                return Direction.UP.directionNumber
            }
        }

        /**
         * 아래 방향으로만 이동 가능한 다리의 모양을 생성하기 위한 클래스
         */
        class BridgeDownNumberGenerator : BridgeNumberGenerator {
            override fun generate(): Int {
                return Direction.DOWN.directionNumber
            }
        }
    }

    lateinit var upBridgeGame:BridgeGame
    lateinit var downBridgeGame:BridgeGame

    @BeforeEach
    fun setUp(){
        upBridgeGame = BridgeGame(BridgeMaker(BridgeUpNumberGenerator()))
        downBridgeGame = BridgeGame(BridgeMaker(BridgeDownNumberGenerator()))

        upBridgeGame.initBridge(3)
        downBridgeGame.initBridge(3)
    }


    @Test
    fun `이동 불가능한 방향으로 이동한 경우 플레이어가 생존할 수 없는지 확인`() {
        assertThat(upBridgeGame.move(Direction.DOWN.direction)).isEqualTo(
            PlayerStatus(
                playerDirection = Direction.DOWN.directionNumber,
                isPlayerAlive = false)
        )
    }

    @Test
    fun `이동 가능한 방향으로 이동한 경우 플레이어가 생존하는지 확인`() {
        val bridgeGame = BridgeGame(BridgeMaker(BridgeUpNumberGenerator()))
        bridgeGame.initBridge(3)

        assertThat(upBridgeGame.move(Direction.UP.direction)).isEqualTo(
            PlayerStatus(
                playerDirection = Direction.UP.directionNumber,
                isPlayerAlive = true)
        )
    }

    @Test
    fun `이동 가능한 방향으로 이동한 경우 게임이 계속되는지 확인`() {
        val playerStatus = upBridgeGame.move(Direction.UP.direction)
        val gameStatus = upBridgeGame.checkGameStatus(playerStatus.isPlayerAlive)

        assertThat(gameStatus).isEqualTo(GameStatus.CONTINUING)
    }

    @Test
    fun `이동 불가능한 방향으로 이동한 경우 게임이 실패하는지 확인`() {
        val playerStatus = downBridgeGame.move(Direction.UP.direction)
        val gameStatus = downBridgeGame.checkGameStatus(playerStatus.isPlayerAlive)

        assertThat(gameStatus).isEqualTo(GameStatus.FAILED)
    }

    @Test
    fun `다리 끝까지 이동했을때 게임 성공을 나타내는지 확인`(){
        downBridgeGame.move(Direction.DOWN.direction)
        downBridgeGame.move(Direction.DOWN.direction)
        val playerStatus = downBridgeGame.move(Direction.DOWN.direction)
        val gameStatus = downBridgeGame.checkGameStatus(playerStatus.isPlayerAlive)

        assertThat(gameStatus).isEqualTo(GameStatus.SUCCEEDED)
    }
}