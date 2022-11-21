package bridge.view

import bridge.domain.Direction
import bridge.domain.Player
import bridge.domain.PlayerBlock
import bridge.sentence.OutputSentence

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(blocks: List<PlayerBlock>) {
        val up = StringBuilder("")
        val down = StringBuilder("")
        appendMark(up, down, MapMark.OPEN)
        blocks.forEachIndexed { index, playerBlock ->
            appendBlock(playerBlock, up, down)
            if (index < blocks.size - 1)
                appendMark(up, down, MapMark.BOUNDARY)
        }
        appendMark(up, down, MapMark.CLOSE)
        println(up.append("\n").append(down).toString())
    }

    private fun appendBlock(
        playerBlock: PlayerBlock,
        up: StringBuilder,
        down: StringBuilder
    ) {
        when (playerBlock.getDirection()) {
            Direction.UP -> {
                up.append(" $playerBlock ")
                down.append("   ")
            }
            Direction.DOWN -> {
                up.append("   ")
                down.append(" $playerBlock ")
            }
        }
    }

    private fun appendMark(up: StringBuilder, down: StringBuilder, mapMark: MapMark) {
        up.append(mapMark.mark())
        down.append(mapMark.mark())
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(player: Player) {
        OutputSentence.RESULT.print()
        val playerBlocks = player.getPlayerBlocks()
        val checkSuccess = if (player.isSuccess()) SUCCESS else FAIL
        printMap(playerBlocks)
        println("\n${OutputSentence.CHECK_SUCCESS.sentence()}$checkSuccess")
        println("${OutputSentence.TOTAL_TRIAL.sentence()}${player.getTries()}")
    }

    companion object {
        const val SUCCESS = "성공"
        const val FAIL = "실패"
    }
}
