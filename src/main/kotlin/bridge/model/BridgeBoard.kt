package bridge.model

class BridgeBoard {
    var board = MutableList(2){ mutableListOf<String>() }

    fun updateBoard(correct: Boolean, moving: String){
        if(correct){
            updateCorrect(moving)
        }else{
            updateWrong(moving)
        }
    }

    private fun updateCorrect(moving: String){
        if(moving == "U")
            updateUpperCorrect()
        else
            updateLowerCorrect()
    }

    private fun updateUpperCorrect(){
        board[0].add("O")
        board[1].add(" ")
    }

    private fun updateUpperWrong(){
        board[0].add("X")
        board[1].add(" ")
    }

    private fun updateWrong(moving: String){
        if(moving == "U")
            updateUpperWrong()
        else
            updateLowerWrong()
    }

    private fun updateLowerCorrect(){
        board[0].add(" ")
        board[1].add("O")
    }

    private fun updateLowerWrong(){
        board[0].add(" ")
        board[1].add("X")
    }


    fun clearBoard(){
        this.board[0].clear()
        this.board[1].clear()
    }

}