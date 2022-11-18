package bridge.domain

class Path(private val path: List<String>) {
    /**
     * @param newDirection 새로 추가 될 이동 방향
     * @return 경로를 추가하여 새로운 일급 컬렉션 객체 반환
     * */
    fun createNewPath(newDirection: String): Path {
        val newPath = ArrayList(path)
        newPath.add(newDirection)

        return Path(path)
    }

    /**
     * @return 진행 중인 라운드 반환
     * */
    fun currentRound(): Int = path.size

    fun checkDirection(direction: String, round: Int): Boolean = direction == path[round]

}