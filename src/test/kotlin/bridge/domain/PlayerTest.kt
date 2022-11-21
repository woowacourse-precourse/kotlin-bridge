package bridge.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PlayerTest {
    @Test
    fun `resetBlocks 메서드를 사용해 사용자가 선택했던 다리의 blocks를 초기화하고 시도 횟수를 늘린다`() {
        val player = Player(mutableListOf(
            PlayerBlock(Direction.DOWN, true),
            PlayerBlock(Direction.UP, true),
            PlayerBlock(Direction.DOWN, false)), 1)
        player.resetBlocks()
        assertThat(player.getPlayerBlocks()).isEmpty()
        assertThat(player.getTries()).isEqualTo(2)
    }

    @Test
    fun `isSuccess 메서드를 사용해 사용자가 최종적으로 게임을 성공했는지 확인`() {
        val players = listOf(
            Player(mutableListOf(
            PlayerBlock(Direction.DOWN, true),
            PlayerBlock(Direction.UP, true),
            PlayerBlock(Direction.DOWN, false)), 1),
            Player(mutableListOf(
                PlayerBlock(Direction.DOWN, true),
                PlayerBlock(Direction.UP, true),
                PlayerBlock(Direction.UP, true)), 1)
        )

        val result = players.map { it.isSuccess() }
        assertThat(result).containsExactly(false, true)
    }
}