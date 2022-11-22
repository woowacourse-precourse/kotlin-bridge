package bridge.view

import bridge.domain.BridgeGameCommand
import bridge.domain.BridgeGameType
import bridge.resources.BRIDGE_MAX_LENGTH
import bridge.resources.BRIDGE_MIN_LENGTH
import bridge.resources.INPUT_BRIDGE_SIZE
import bridge.resources.INPUT_GAME_COMMAND
import bridge.resources.INPUT_MOVING
import bridge.utils.infinityRead
import bridge.utils.toInListOrError
import bridge.utils.toIntInRangeOrError
import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        return infinityRead {
            println(INPUT_BRIDGE_SIZE)
            Console.readLine().toIntInRangeOrError(BRIDGE_MIN_LENGTH, BRIDGE_MAX_LENGTH)
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        return infinityRead {
            println(INPUT_MOVING)
            Console.readLine().toInListOrError(BridgeGameType.getTypeList())
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return infinityRead {
            println(INPUT_GAME_COMMAND)
            Console.readLine().toInListOrError(BridgeGameCommand.getCommandList())
        }
    }
}
