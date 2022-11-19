package bridge

class BridgeComparator {
    // -> 근데 그냥 bridgeGame에서 계산해도 될듯? 그냥 함수만 만들어서 거기에 bridgeMap이 있으니까
    // 이도 가능한지 계산한다.

    fun calculateIsMovable(bridgeMap: List<String>, moving: String, position: Int): Boolean {
        return bridgeMap[position] == moving
    }
}