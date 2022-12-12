package bridge.domain

class Player {

    private var record = mutableListOf<String>()
    private var position = -1

    fun go(move: String) {
        record.add(move)
        position++
    }

    fun initialize() {
        position = -1
        record.clear()
    }

    fun isFinish(bridge: Bridge): Boolean {
        return bridge.crossedAll(record)
    }

    fun doNotGo(bridge: Bridge): Boolean {
        return bridge.doNotCross(record.last(), position)
    }

    fun getRecord(): MutableList<String> {
        return record
    }
}
