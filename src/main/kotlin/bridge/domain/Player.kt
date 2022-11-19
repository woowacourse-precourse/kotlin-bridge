package bridge.domain

class Player {

    fun go(move: String) {
        record.add(move)
        position++
    }

    fun doNotGo(bridge: List<String>): Boolean {
        return bridge[position] != record.last()
    }

    fun getState(): MutableList<String> {
        return record
    }

    companion object {
        private var record = mutableListOf<String>()
        private var position = -1
    }
}
