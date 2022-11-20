package bridge.model

import bridge.*

class ProgressMatrix {
    lateinit var progress: Array<Array<String>>

    fun initMatrix(rowCount: Int) {
        progress = Array(COLUMN_COUNT) { Array(rowCount) { NULL } }
    }

    fun saveMatrix(s: String, ox: String, pos: Int) {
        if (s == UP) {
            progress[UPSIDE][pos] = ox
            progress[DOWNSIDE][pos] = BLANK
        } else {
            progress[UPSIDE][pos] = BLANK
            progress[DOWNSIDE][pos] = ox
        }
    }
}