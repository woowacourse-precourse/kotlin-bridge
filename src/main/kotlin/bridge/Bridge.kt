package bridge

data class Bridge(val steps: List<String>) {

    fun matchUserChoice(userChoice: String, position: Int): Boolean {
        if (steps[position] == userChoice) return true
        return false
    }
}