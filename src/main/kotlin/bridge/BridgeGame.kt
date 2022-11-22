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
    fun move(mybridge: List<String>): List<String> {
        val updown = InputView().readMoving()
        val temp = mutableListOf<String>()

        for(i in mybridge){
            temp.add(i)
        }

        temp.add(updown)

        return temp
    }

    fun playgame(bridge: List<String>){
        var mybridge:List<String> = listOf()

        while(mybridge.size != bridge.size && check == 0){
            mybridge = BridgeGame().move(mybridge)
            OutputView().printMap(bridge,mybridge)
        }

        OutputView().printResult(bridge,mybridge)
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry(bridge: List<String>, mybridge: List<String>) {
        val regame = InputView().readGameCommand()

        if(regame=="R")
            BridgeGame().playgame(bridge)
        if(regame=="Q")
            OutputView().printResult(bridge, mybridge)
    }
}
