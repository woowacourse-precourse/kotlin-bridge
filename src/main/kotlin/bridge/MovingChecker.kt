package bridge

class MovingChecker(private val input: String?) {
    fun checkAll(): Boolean {
        try {
            checkValue()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            return true
        }
        return false
    }

    private fun checkValue() {
        if (input != "U" && input != "D") {
            throw IllegalArgumentException("[ERROR] 이동할 칸은 U 또는 D여야 합니다.")
        }
    }
}