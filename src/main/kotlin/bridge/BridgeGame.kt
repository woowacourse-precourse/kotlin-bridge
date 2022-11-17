package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(bridge : List<String>) {
        val move = InputView().readMoving()
        when(move == bridge[order]){
            true -> moveSuccess(bridge)
            false -> moveFail(bridge)
        }
    }

    fun discriminateEnd(size : Int){
        if(order==size-1){
            endGame=true
            result=success
        }
        if(order!=size-1)
            order++
    }

    fun moveSuccess(bridge: List<String>){
        if(bridge[order]=="U"){
            upBridge.add("O")
            downBridge.add(" ")
        }
        if(bridge[order]=="D"){
            upBridge.add(" ")
            downBridge.add("O")
        }
        OutputView().printMap()
        discriminateEnd(bridge.size)
    }

    fun moveFail(bridge: List<String>){
        if(bridge[order]=="U"){
            upBridge.add(" ")
            downBridge.add("X")
        }
        if(bridge[order]=="D"){
            upBridge.add("X")
            downBridge.add(" ")
        }
        OutputView().printMap()
        retry()
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {
        val answer = InputView().readGameCommand()
        if(answer == "Q"){
            endGame=true
        }
        if(answer =="R"){
            reset()
        }
    }

    fun reset(){
        tryCount++
        order=0
        upBridge.clear()
        downBridge.clear()
    }
    companion object{
        var upBridge = mutableListOf<String>()
        var downBridge = mutableListOf<String>()
        const val success = true
    }
}
