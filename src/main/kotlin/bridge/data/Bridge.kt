package bridge.data

class Bridge(
    private val bridge: List<String>
) {

    init {
        require(bridge.size in SizeRange) { "Bridge's size is required in $SizeRange" }
        require(bridge.all { Floor.contains(it) }) { "Invalid bridge's elements" }
    }

    enum class Floor(val command: String) {
        DOWN("D"), UP("U");

        companion object {
            private val values = values()

            operator fun get(ordinal: Int): Floor {
                return values[ordinal]
            }

            operator fun contains(value: String): Boolean {
                return values.any { it.command == value || it.name == value }
            }

            fun getOrNull(value: String): Floor? {
                return values.find { it.command == value || it.name == value }
            }
        }
    }

    companion object {
        const val SIZE_MIN = 3
        const val SIZE_MAX = 20

        val SizeRange = SIZE_MIN..SIZE_MAX
    }
}