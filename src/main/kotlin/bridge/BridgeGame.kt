package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame constructor(bridge : MutableList<String>){
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

    fun retry() {
        this.userBridge = mutableListOf<String>()
        this.cnt++
    }

    fun getCount() : Int{
        return this.cnt
    }
}
