package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(val answerWay: List<String>,var myBridge: Bridge,var status: Status) {
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move():Boolean {
        myBridge.choiceStep()
        return myBridge.move(answerWay)
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {
    }

    fun play(){
        while(move()){
            if(myBridge.getMyWaySize()>=answerWay.size){ //성공
                status.success="성공"
                //결과 출력
                showResult()

                return
            }
        }
        //재시도 묻기
    }
    fun showResult(){
        myBridge.showResult(answerWay,status.success,status.tryCount)
    }
}
