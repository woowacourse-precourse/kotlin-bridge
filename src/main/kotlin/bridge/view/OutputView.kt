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

    fun printResult(success: Boolean, attempts: Int, board: MutableList<MutableList<String>>) {
        println("최종 게임 결과")
        printMap(board)
        print("게임 성공 여부: ")
        if(success)
            println("성공")
        else
            println("실패")
        println("총 시도한 횟수: $attempts")

    }

    fun printReadBridgeSizeMessage(){
        println("다리의 길이를 입력해주세요.")
    }

    fun printReadMovingMessage(){
        println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
    }

    fun printReadGameCommandMessage(){
        println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
    }

    fun printErr(errMessage: String){
        println(errMessage)
    }
}
