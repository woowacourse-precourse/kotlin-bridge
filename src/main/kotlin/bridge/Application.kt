package bridge

fun main() {
    val inputView = InputView()
    val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())

    println("다리 건너기 게임을 시작합니다.")
    val size = inputView.readBridgeSize()
    val answerBridge = bridgeMaker.makeBridge(size)
    var attempt = 0
    var gamePlay = true
    while (gamePlay){
        attempt++
        val attemptOver = crossBridge(answerBridge, size)
        if(attemptOver.isInterrupted()){ //실패해서 중간에 중단된 경우
            val gameCommand = inputView.readGameCommand()
            gamePlay = BridgeGame().retry(gameCommand) //재시도하는 경우 -> 처음부터 시작
        }
        if(!attemptOver.isInterrupted()){ //성공으로 인한 게임 종료
            gamePlay = false
        }
        if(!gamePlay){ //최종 결과 출력
            OutputView().printResult(attemptOver.getUserMoveHistory(), answerBridge, attempt)
        }
    }
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