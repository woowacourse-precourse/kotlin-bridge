package bridge

fun main() {
    // TODO: 프로그램 구현
}
fun showResult(moves: List<String>, answers: List<String>, attempt:Int) : Boolean{
    OutputView().printMap(moves,answers)
    if(moves[attempt] != answers[attempt]){ //정답이 아닌 경우
        return true
    }
    return false
}

fun crossBridge(answers: List<String>, size: Int): MoveResult{
    val userMoves = mutableListOf<String>()
    for(attempt in 0 until size){
        val nextMove = InputView().readMoving()
        userMoves.add(nextMove)
        val interrupted = showResult(userMoves, answers, attempt)
        if(interrupted){
            return MoveResult(userMoves,true)
        }
    }
    return MoveResult(userMoves,false)
}

class MoveResult(private val moves: List<String>, private val interrupted:Boolean){
    fun isInterrupted() : Boolean{
        return interrupted
    }

    fun getUserMoveHistory(): List<String>{
        return moves
    }
}