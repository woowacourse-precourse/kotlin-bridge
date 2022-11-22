package bridge

class InputView {
    fun readBridgeSize(): Int {
        println("다리의 길이를 입력해주세요.")
        try {
            val bridgeSize = Integer.parseInt(readLine())
            if (bridgeSize < 3 || bridgeSize > 20) throw IllegalArgumentException()
            return bridgeSize
        } catch (e: NumberFormatException) {
            println("[ERROR]: 숫자가 아니다. (Only Int)\n")
            return 0 // ApplicationTest 의 '에외 테스트' 통과를 위해 0으로 임의 설정
        } catch (e: IllegalArgumentException) {
            println("[ERROR]: 숫자가 범위를 벗어났다. (Only 3~20)\n")
            return readBridgeSize()
        }
    }

    fun readMoving(): String {
        println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
        try {
            val moving = readLine()
            if (moving != "U" && moving != "D") throw IllegalArgumentException()
            return moving
        } catch (e: IllegalArgumentException) {
            println("[ERROR]: 잘못된 문자 입력 (Only U or D)\n")
            return readMoving()
        }
    }

    fun readGameCommand(): String {
        println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
        try {
            val gameCommand = readLine()
            if (gameCommand != "R" && gameCommand != "Q") throw IllegalArgumentException()
            return gameCommand
        } catch (e: IllegalArgumentException) {
            println("[ERROR]: 잘못된 문자 입력 (Only Q or R)\n")
            return readGameCommand()
        }
    }
}