package bridge

/*
* - bridgeSize:
  1. 사용자가 3 ~ 20 범위 밖의 값을 입력했을 때
  2. int가 아닌 값을 입력했을 때

- direction:
  1. U, D 외의 값을 입력했을 때

- retry/quit
  1. R, Q 이 아닌 값을 입력했을 때
*
* */
class Error {
    fun checkBridgeSize(bridgeSize: String): Boolean {
        try{
            if ( bridgeSize.toIntOrNull() == null ) throw IllegalArgumentException("[ERROR] 정수를 입력해 주세요.")
            if ( bridgeSize.toInt() < 3 || bridgeSize.toInt() > 20 ) throw IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.")
        } catch (e: IllegalArgumentException) {
            println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.")
            return false
        } catch (e: NumberFormatException) {
            println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.")
            return false
        } catch (e: NullPointerException) {
            println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.")
            return false
        }
        return true
    }

    fun checkDirection(movingDirection: String): Boolean {
        try{
            if ( movingDirection != "U" || movingDirection != "D" ) throw IllegalArgumentException("[ERROR] U(위) 또는 D(아래)를 입력하셔야 합니다.")
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("[ERROR] U(위) 또는 D(아래)를 입력하셔야 합니다.")
            return false
        }
        return true
    }

    fun checkGameCommand(gameCommand: String): Boolean {
        try{
            if ( gameCommand != "R" || gameCommand != "Q" ) throw IllegalArgumentException("[ERROR] R(재시도) 또는 Q(종료)를 입력하셔야 합니다.")
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("[ERROR] R(재시도) 또는 Q(종료)를 입력하셔야 합니다.")
            return false
        }
        return true
    }

}