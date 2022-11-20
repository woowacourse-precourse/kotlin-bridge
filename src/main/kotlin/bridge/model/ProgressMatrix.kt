package bridge.model

import bridge.COLUMN_COUNT
import bridge.NULL

class ProgressMatrix {
    lateinit var progress: Array<Array<String>>

    // 초기화
    fun initMatrix(rowCount: Int) {
        progress = Array(COLUMN_COUNT) { Array(rowCount) { NULL } }
    }
}