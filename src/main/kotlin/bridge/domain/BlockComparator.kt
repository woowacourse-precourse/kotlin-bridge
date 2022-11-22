package bridge.domain

import bridge.common.UpDown

class BlockComparator() {
    fun compareIsUpperCorrect(direction: String): String {
        return UpDown.valueOf(direction).up
    }

    fun compareIsDownerCorrect(direction: String): String {
        return UpDown.valueOf(direction).down
    }

    fun compareIsUpperIncorrect(direction: String): String {
        return UpDown.valueOf(direction).upMismatch
    }

    fun compareIsDownerIncorrect(direction: String): String {
        return UpDown.valueOf(direction).downMismatch
    }
}
