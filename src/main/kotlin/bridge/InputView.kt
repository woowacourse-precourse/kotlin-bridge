package bridge

import bridge.BridgeGame.Companion.BRIDGE_LENGTH_LOWER_INCLUSIVE
import bridge.BridgeGame.Companion.BRIDGE_LENGTH_UPPER_INCLUSIVE
import bridge.BridgeGame.Companion.GAME_COMMAND_QUIT
import bridge.BridgeGame.Companion.GAME_COMMAND_RESTART
import bridge.BridgeGame.Companion.MOVING_DIRECT_DOWN
import bridge.BridgeGame.Companion.MOVING_DIRECT_UP
import bridge.OutputView.Companion.printErrorMessage
import bridge.exception.BridgeSizeInvalidException
import bridge.exception.GameCommandInvalidException
import bridge.exception.MovingInvalidException
import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        var bridgeSize = readValidatedBridgeSize()
        while (bridgeSize == 0) {
            bridgeSize = readValidatedBridgeSize()
        }
        return bridgeSize
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        var moving = readValidatedMoving()
        while (moving.isBlank()) {
            moving = readValidatedMoving()
        }
        return moving
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): Char {
        var gameCommand = readValidatedGameCommand()
        while (gameCommand == ' ') {
            gameCommand = readValidatedGameCommand()
        }
        return gameCommand
    }

    private fun readValidatedBridgeSize(): Int {
        return try {
            with(Console.readLine().toInt()) {
                if (this in BRIDGE_LENGTH_LOWER_INCLUSIVE..BRIDGE_LENGTH_UPPER_INCLUSIVE) this
                else throw NumberFormatException()
            }
        } catch (e: Exception) {
            printErrorMessage(BridgeSizeInvalidException())
            0
        }
    }

    private fun readValidatedMoving(): String {
        return try {
            with(Console.readLine()) {
                if (this.length == 1 && (this == MOVING_DIRECT_UP || this == MOVING_DIRECT_DOWN)) this
                else throw IllegalArgumentException()
            }
        } catch (e: Exception) {
            printErrorMessage(MovingInvalidException())
            ""
        }
    }

    private fun readValidatedGameCommand(): Char {
        return try {
            with(Console.readLine()) {
                if (this.length == 1 && (this[0] == GAME_COMMAND_RESTART || this[0] == GAME_COMMAND_QUIT)) this[0]
                else throw IllegalArgumentException()
            }
        } catch (e: Exception) {
            printErrorMessage(GameCommandInvalidException())
            ' '
        }
    }
}