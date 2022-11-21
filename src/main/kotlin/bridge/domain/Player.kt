package bridge.domain

class Player {

    private var record = mutableListOf<String>()
    private var position = -1

    fun go(move: String) {
        record.add(move)
        position++
    }

    fun doNotGo(bridge: List<String>): Boolean {
        return bridge[position] != record.last()
    }

    fun initialize() {
        position = -1
        record.clear()
    }

    fun getRecord(): MutableList<String> {
        return record
    }
}
