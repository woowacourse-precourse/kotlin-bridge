package bridge

import bridge.constructor.DiscoveredBridge
import bridge.constructor.UpDown

class Comparator(
    private val bridge: List<String>
) {
    private val upperResults = mutableListOf<String>()
    private val downerResults = mutableListOf<String>()

    fun compareInput(input: String): DiscoveredBridge {
        val position = upperResults.size
        if (input == bridge[position]) {
            upperResults.add(UpDown.valueOf(input).up)
            downerResults.add(UpDown.valueOf(input).down)
        }
        return DiscoveredBridge(upperResults, downerResults)
    }
}
