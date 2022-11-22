package bridge.ui.view

import bridge.common.*

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     */
    fun printMap(mapInfo: List<String>) {
        mapInfo.forEach { map ->
            println(map)
        }
    }

    /**
     * 게임의 최종 결과를 출력하는 메서드
     */
    fun printResult(mapInfo: List<String>, gameSuccessResult: String, numberOfTry: Int) {
        print(FINAL_GAME_RESULT_MESSAGE)

        printMap(mapInfo = mapInfo)

        print(GAME_SUCCESSFUL_FORMAT.format(gameSuccessResult))
        print(GAME_TRY_NUMBER_FORMAT.format(numberOfTry))
    }

    fun printMessage(message: String) = print(message)
}
