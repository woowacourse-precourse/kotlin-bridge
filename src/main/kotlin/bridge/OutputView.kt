package bridge

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    init{
        println("다리 건너기 게임을 시작합니다.")
    }
    private lateinit var playerPathMap: Array<String>

    fun initPathMap(bridgeSize: Int) {
        playerPathMap = Array(2) { NOT_INITIALIZED.repeat(bridgeSize) }
    }

    /**
     * 이동 경로를 최신화 하기 위한 함수이다.
     */
    fun recordPlayerMoving(playerStatus: PlayerStatus) {
        var recordSign = AVAILABLE_PATH
        if (!playerStatus.isPlayerAlive) {
            recordSign = UNAVAILABLE_PATH
        }
        playerPathMap[playerStatus.playerDirection] =
            playerPathMap[playerStatus.playerDirection].replaceFirst("N", recordSign)
        playerPathMap[playerStatus.playerDirection.oppositeDirection()] =
            playerPathMap[playerStatus.playerDirection.oppositeDirection()].replaceFirst("N", " ")
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap() = playerPathMap.forEach { eachMap ->
        println(eachMap.formattingMap())
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(numberOfTry: Int, gameStatus: GameData) {
        println(GAME_RESULT)
        printMap()
        println(GAME_RESULT_FLAG.format(gameStatus.gameMsg))
        println(THE_NUMBER_OF_TRY.format(numberOfTry))
    }

    private fun String.formattingMap() =
        this.replace(NOT_INITIALIZED, "")
            .replace(SUCCESSIVE_PARENTHESIS, CONNECT_PARENTHESIS)

    private fun Int.oppositeDirection() = if (this == 0) {
        1
    } else {
        0
    }

    companion object{
        const val GAME_RESULT = "최종 게임 결과"
        const val GAME_RESULT_FLAG = "게임 성공 여부: %s"
        const val THE_NUMBER_OF_TRY = "총 시도한 횟수: %d"
    }
}
