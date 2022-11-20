package bridge.view

import bridge.constructor.DiscoveredBridge

private const val BRIDGE_START = "[ "
private const val BRIDGE_END = " ]"
private const val DIVISION_LINE = " | "

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(discoveredBridge: DiscoveredBridge) {
        printBlocks(discoveredBridge.upperBlocks)
        printBlocks(discoveredBridge.downerBlocks)
    }

    private fun printBlocks(blocks: List<String>) {
        println(blocks.joinToString(prefix = BRIDGE_START, postfix = BRIDGE_END, separator = DIVISION_LINE))
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult() {}
}
