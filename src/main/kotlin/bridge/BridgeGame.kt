package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(val bridge: List<String>) {
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    var route = mutableListOf<String>()
    var tryNum = 1

    fun move(direction: String): Boolean {
        route.add(direction)
        //    println("route : ${route[route.lastIndex]} ${route.lastIndex}")
        return route[route.lastIndex] == bridge[route.lastIndex]
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {
        route.clear()
        OutputView().able1.clear()
        OutputView().able2.clear()

        tryNum++   // 재시도 횟수
    }

    fun quit(): Boolean {
        return bridge.size == route.size
    }
}
