package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {
    var tryGame: Int = 0
    var moveData = mutableListOf<String>()
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(input:String) {
        moveData.add(input)
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {
        tryGame++
    }

    fun compareAnswer(bridgeData:List<String>): List<String>{
        val compareList = moveData
        for(i in 0 until moveData.size){
            if(moveData[i]!=bridgeData[i] && moveData[i] == "U") {
                compareList[i]="UX"
            }
            if(moveData[i]!=bridgeData[i] && moveData[i] == "D") {
                compareList[i]="DX"
            }
        }
        return compareList.toList()
    }

    fun resultToString(result:List<String>):String{

    }
}
