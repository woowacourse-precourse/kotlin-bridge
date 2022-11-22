package bridge.view

import bridge.domain.error.ErrorCheck
import bridge.domain.resource.*
import camp.nextstep.edu.missionutils.Console.readLine

class InputView {

    fun readBridgeSize(): Int {
        println(INPUT_BRIDGE_LENGTH)

        val size = readLine().trim()
        ErrorCheck.checkIsInteger(size)
        ErrorCheck.checkInRange(size.toInt())

        return size.toInt()
    }

    fun readMoving(): String {
        println(INPUT_MOVEMENT)

        val movement = readLine().trim()
        ErrorCheck.checkValidMovement(movement)

        return movement
    }

    fun readGameCommand(): String {
        println(INPUT_RESTART)

        val restart = readLine().trim()
        ErrorCheck.checkValidCommand(restart)

        return restart
    }

    companion object {
        const val INPUT_BRIDGE_LENGTH = "다리의 길이를 입력해주세요."
        const val INPUT_MOVEMENT = "\n이동할 칸을 선택해주세요. (위: ${MOVE_UP}, 아래: ${MOVE_DOWN})"
        const val INPUT_RESTART = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: $GAME_RESTART, 종료: $GAME_END)"
    }
}
