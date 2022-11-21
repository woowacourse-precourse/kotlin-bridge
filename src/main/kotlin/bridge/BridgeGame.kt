package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame constructor(bridge : MutableList<String>){
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    var cnt : Int
    var bridge : MutableList<String>
    var userBridge = mutableListOf<String>()
    init {
        this.bridge = bridge
        this.cnt = 1
    }

    fun move(upOrDown : String) : Boolean{
        val idx = userBridge.size
        if(this.bridge.get(idx).equals(upOrDown)){
            userBridge.add(upOrDown)
            return true
        }
        userBridge.add(upOrDown)
        return false
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {
        this.userBridge = mutableListOf<String>()
        this.cnt++
    }

    fun getCount() : Int{
        return this.cnt
    }
}
