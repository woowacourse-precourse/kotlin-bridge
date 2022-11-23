package bridge.model

import bridge.Constans.BLANK
import bridge.Constans.COLUMN_COUNT
import bridge.Constans.DOWNSIDE
import bridge.Constans.NULL
import bridge.Constans.UP
import bridge.Constans.UPSIDE

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