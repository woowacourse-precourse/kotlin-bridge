package bridge.view

import bridge.utils.ExceptionChecker

class InputView {
    private val exceptionChecker = ExceptionChecker()

    fun readBridgeSize(): Int {
        println("다리의 길이를 입력해주세요.")
        val bridgeSize = readLine()!!
        exceptionChecker.bridgeSizeIsDigitException(bridgeSize)
        exceptionChecker.bridgeSizeIsInRangeException(bridgeSize.toInt())
        return bridgeSize.toInt()
    }

    fun readMoving(): String {
        println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
        val userMove = readLine()!!
        exceptionChecker.movingException(userMove)
        return userMove
    }

    fun readGameCommand(): String {
        println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
        val retry = readLine()!!
        //todo: 예외처리 필요
        return retry
    }
}
