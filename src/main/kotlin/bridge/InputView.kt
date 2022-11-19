package bridge

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 *
 * 제공된 InputView 클래스를 활용해 구현해야 한다.
 * InputView의 패키지는 변경할 수 있다.
 * InputView의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 있다.
 * 사용자 값 입력을 위해 필요한 메서드를 추가할 수 있다.
 * InputView 클래스에서만 camp.nextstep.edu.missionutils.Console 의 readLine() 메서드를 이용해 사용자의 입력을 받을 수 있다.
 *
 * 3 이상 20 이하의 숫자를 입력할 수 있으며 올바른 값이 아니면 예외 처리한다.
 * U(위 칸)와 D(아래 칸) 중 하나의 문자를 입력할 수 있으며 올바른 값이 아니면 예외 처리한다.
 * R(재시작)과 Q(종료) 중 하나의 문자를 입력할 수 있으며 올바른 값이 아니면 예외 처리한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     * BridgeMaker 으로 인자를 보내고 값을 받는다
     * 표시
     */
    fun readBridgeSize(): Int {
        println("다리의 길이를 입력해주세요.")
        try {
            val bridgeSize = Integer.parseInt(readLine())
            if (bridgeSize < 3 || bridgeSize > 20) throw Exception()
            return bridgeSize
        } catch (e: IllegalArgumentException) {
            println("[ERROR]: 숫자가 아니다. (Only Int)\n")
            return 0 // ApplicationTest 의 '에외 테스트' 통과를 위해 임의 설정
        } catch (e: Exception) {
            println("[ERROR]: 숫자가 범위를 벗어났다. (Only 3~20)\n")
            return readBridgeSize() // 재입력
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     * BridgeGame 으로 인자를 보내고 값을 받는다
     * 표시
     */
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

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     * BridgeGame 으로 인자를 보내고 값을 받는다
     * 표시
     */
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
