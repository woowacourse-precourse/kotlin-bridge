package bridge.domain.game

class Bridge(private val elements: List<Floor>) {

    val size: Int get() = elements.size

    init {
        require(elements.size in SizeRange) { "Bridge's size is required in $SizeRange" }
    }

    operator fun get(index: Int): Floor = elements[index]

    enum class Floor(val command: String) {
        DOWN("D"), UP("U");

        companion object {
            private val values = values()

            operator fun contains(value: String): Boolean {
                return values.any { it.command == value || it.name == value }
            }

            operator fun get(value: String): Floor {
                return values.find { it.command == value || it.name == value }!!
            }

            fun getOrNull(value: String): Floor? {
                return values.find { it.command == value || it.name == value }
            }

            fun indexOf(ordinal: Int): Floor {
                return values[ordinal]
            }
        }
    }

    companion object {
        const val SIZE_MIN = 3
        const val SIZE_MAX = 20

        val SizeRange = SIZE_MIN..SIZE_MAX

        fun newInstance(floors: List<String>): Bridge {
            require(floors.all { it in Floor })

            return Bridge(floors.map { Floor[it] })
        }
    }
}