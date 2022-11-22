package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {
    private lateinit var bridge: List<String>
    private var userInput = mutableListOf<String>()
    private var inputCount = 0
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(input: String):Boolean {
        if(checkSuccessorFail(input)) {
            userInput.add(input)
            inputCount++
            return true
        }
        return false
    }

    private fun checkSuccessorFail(input: String):Boolean{
        return input == bridge[inputCount]
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry(input: String):Boolean {
        return input=="R"
    }

    fun loadBridge(bridge: List<String>){
        this.bridge = bridge
    }
    fun initUserInput(){
        this.userInput.clear()
        this.inputCount = 0
    }

    fun getBridge():List<String>{
        return this.bridge
    }

    fun getUserInput():List<String>{
        return this.userInput
    }

    fun checkIsGameFinish(): Boolean {
        return userInput.size == bridge.size
    }
}
