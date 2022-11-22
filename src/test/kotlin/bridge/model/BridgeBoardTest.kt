package bridge.model

import bridge.main
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class BridgeGameTest {
    @Test
    fun `update Test`(){
        val board = BridgeBoard()
        board.updateBoard(true, "D")
        board.updateBoard(false, "U")

        var correctBoard = MutableList(2){ mutableListOf<String>() }
        correctBoard[0].add(" ")
        correctBoard[0].add("X")
        correctBoard[1].add("O")
        correctBoard[1].add(" ")

        assertThat(board.board).isEqualTo(correctBoard)
    }

    @Test
    fun `clear Test`(){
        val board = BridgeBoard()
        board.updateBoard(true, "D")
        board.updateBoard(false, "U")
        board.clearBoard()

        var correctBoard = MutableList(2){ mutableListOf<String>() }

        assertThat(board.board).isEqualTo(correctBoard)
    }

    fun runMain() {
        main()
    }
}