package bridge.domain.game

class Bridge(private val floors: List<Floor>) {

    val size: Int get() = floors.size

    init {
        require(floors.size in SizeRange) { "Bridge's size is required in $SizeRange" }
    }

    operator fun get(index: Int): Floor = floors[index]

    enum class Floor(val value: String, val number: Int) {
        Down("D", 0), Up("U", 1);

        companion object {
            private val values = values()

            operator fun contains(value: String): Boolean = values.any { it.value == value }

            fun parse(number: Int): Floor? = values.find { it.number == number }

            fun parse(value: String): Floor? = values.find { it.value == value }
        }
    }

    companion object {
        const val SIZE_MIN = 3
        const val SIZE_MAX = 20

        val SizeRange = SIZE_MIN..SIZE_MAX
    }
}