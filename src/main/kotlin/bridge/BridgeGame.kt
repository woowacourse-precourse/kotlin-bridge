package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {

    var count = 1
    var idx = 0
    var success = 0

    var size: Int = 0
    var answerList = mutableListOf<String>()
    val inputList = mutableListOf<String>()



    fun checkStep(): Boolean {
        return inputList[idx] == answerList[idx]
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(command:String) : Int {

        inputList.add(command)


        return success

    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {
        idx = 0
        inputList.clear()
        count++
    }
}
