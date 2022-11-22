package bridge.view

import bridge.util.Converter
import bridge.validation.InputValidation
import camp.nextstep.edu.missionutils.Console

class InputView {

    private val inputValidation = InputValidation()
    private val converter = Converter()

    fun readBridgeSize(): Int {
        return try{
            println(INPUT_BRIDGE_SIZE_MESSAGE)
            val input = Console.readLine()
            inputValidation.checkInputInteger(input)
            inputValidation.checkBridgeSizeRange(converter.convertStringToInt(input))
            converter.convertStringToInt(input)
        }catch (e:IllegalArgumentException){
            println(e.message)
            readBridgeSize()
        }
    }

    fun readMoving(): String {
        println(INPUT_MOVING_MESSAGE)
        val moving = Console.readLine()
        return try {
            inputValidation.checkInputLength(moving)
            inputValidation.checkUserMovingValidation(moving)
            moving
        }catch (e:IllegalArgumentException){
            println(e.message)
            readMoving()
        }
    }

    fun readGameCommand(): String {
        return try {
            println(INPUT_GAME_COMMAND_MESSAGE)
            val gameCommand = Console.readLine()
            inputValidation.checkInputLength(gameCommand)
            inputValidation.checkUserRestartValidation(gameCommand)
            gameCommand
        }catch (e:IllegalArgumentException){
            println(e.message)
            readGameCommand()
        }
    }

    companion object {
        const val INPUT_BRIDGE_SIZE_MESSAGE = "\n다리의 길이를 입력해주세요."
        const val INPUT_MOVING_MESSAGE = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)"
        const val INPUT_GAME_COMMAND_MESSAGE = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
    }
}
