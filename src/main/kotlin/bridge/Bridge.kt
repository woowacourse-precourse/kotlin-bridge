package bridge

data class Bridge(val steps: List<String>) {

    fun matchUserChoice(moving: String, position: Int): Boolean {
        if (steps[position] == moving) return true
        return false
    }
}