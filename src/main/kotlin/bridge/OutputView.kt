package bridge

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(playerPath: List<String>, isPlayerAlive: Boolean) {
        val upBridgePath = playerPath.pathToMap("U", isPlayerAlive)
        val downBridgePath = playerPath.pathToMap("D", isPlayerAlive)

        println(upBridgePath)
        println(downBridgePath)
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult() {}

    /**
     * @param 위 방향의 다리 경로를 위한 출력인지 아래 방향의 다리 경로를 위한 출력인지
     */
    fun List<String>.pathToMap(direction: String, isPlayerAlive: Boolean): String {
        val path = StringBuilder().append("[")

        for (turn in 0 until this.size - 1) {
            when (this[turn]) {
                direction -> path.append(" O |")
                else -> path.append("   |")
            }
        }
        if (this.last() == direction) {
            if (isPlayerAlive) {
                path.append(" O ]")
            } else {
                path.append(" X ]")
            }
        } else {
            path.append("   ]")
        }
        return path.toString()
    }

    fun String.directionToInt() = if (this == "D") {
        0
    } else {
        1
    }
}
