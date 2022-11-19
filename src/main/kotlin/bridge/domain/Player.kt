package bridge.domain

import bridge.util.Constant.LOAD_GO
import bridge.util.Constant.LOAD_STOP

class Player {

    fun go(move: String, bridge: List<String>) {
        when (canGo(move, bridge)) {
            YES -> record.add(LOAD_GO)
            NO -> record.add(LOAD_STOP)
        }
    }

    private fun canGo(move: String, bridge: List<String>): Boolean {
        return bridge[record.size] == move
    }

    fun getState(): MutableList<String> {
        return record
    }

    companion object {
        private var record = mutableListOf<String>()
        const val YES = true
        const val NO = false
    }
}
