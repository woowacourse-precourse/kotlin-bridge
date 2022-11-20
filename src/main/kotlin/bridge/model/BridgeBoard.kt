package bridge.model

class BridgeBoard {
    var board = MutableList(2){ mutableListOf<String>() }

    fun updateBoard(correct: Boolean, moving: String){
        if(correct){
            if(moving == "U") {
                board[0].add("O")
                board[1].add(" ")
            }else{
                board[0].add(" ")
                board[1].add("O")
            }
        }else{
            if(moving == "U"){
                board[0].add("X")
                board[1].add(" ")
            }else{
                board[0].add(" ")
                board[1].add("X")
            }
        }
    }

}