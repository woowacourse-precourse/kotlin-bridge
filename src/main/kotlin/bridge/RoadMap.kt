package bridge

class RoadMap {
    private var roadMap = List(2) { mutableListOf<String>() }

    fun resetRoadMap() {
        roadMap[0].clear()
        roadMap[1].clear()
    }

    fun addSuccessRoad(way: String) {
        when (way) {
            "U" -> {
                roadMap[0].add("O")
                roadMap[1].add(" ")
            }

            "D" -> {
                roadMap[0].add(" ")
                roadMap[1].add("O")
            }
        }
    }

    fun addFailRoad(way: String) {
        when (way) {
            "U" -> {
                roadMap[0].add("X")
                roadMap[1].add(" ")
            }

            "D" -> {
                roadMap[0].add(" ")
                roadMap[1].add("X")
            }
        }
    }

    fun getRoadMap(): List<List<String>> {
        return roadMap
    }

}