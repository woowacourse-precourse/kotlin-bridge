package bridge.view

class OutputView {

    fun printStartMessage() {
        println("다리 건너기 게임을 시작합니다.")
    }

    fun printMap(board: MutableList<MutableList<String>>) {
        var upperBoard = "[ "
        var lowerBoard = "[ "

        for(i in board[0].indices){
            if(i == board[0].size-1) {
                upperBoard += "${board[0][i]} ]"
                lowerBoard += "${board[1][i]} ]"
            }else{
                upperBoard += "${board[0][i]} | "
                lowerBoard += "${board[1][i]} | "
            }
        }
        println("$upperBoard\n$lowerBoard")
    }

    fun printResult() {}
}
