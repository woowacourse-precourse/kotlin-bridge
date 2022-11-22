package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(private val bridge : List<String>) {
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * @param index: 현재 bridge 진행 상황
     * @param userInput: User 선택한 곳
     * @return: 정답일 경우 (Correct) 오답일 경우 (Wrong)
     */
    fun move(index:Int,userInput:String): String {
        val bridgeInfo = bridge[index]
        if(bridgeInfo==userInput)
            return MoveResult.CORRECT.message
        return MoveResult.WRONG.message
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * tryCount 를 1 증가시킨다.
     * @param tryCount: 현재까지 시도한 횟수
     * @return : 시도 횟수 1 증가
     */
    fun retry(tryCount: Int):Int{
        return tryCount+1
    }

    enum class MoveResult(
        val message:String
    ){
        CORRECT("Correct"),
        WRONG("Wrong")
    }
}
