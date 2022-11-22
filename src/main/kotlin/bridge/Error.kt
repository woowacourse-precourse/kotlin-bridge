package bridge

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
            if ( movingDirection == "U" || movingDirection == "D") {}
            else throw IllegalArgumentException("[ERROR] U(위) 또는 D(아래)를 입력하셔야 합니다.")
        } catch (e: IllegalArgumentException) {
            println("[ERROR] U(위) 또는 D(아래)를 입력하셔야 합니다.")
            return false
        } catch (e: NullPointerException) {
            println("[ERROR] U(위) 또는 D(아래)를 입력하셔야 합니다.")
            return false
        }
        return true
    }

    fun checkGameCommand(gameCommand: String): Boolean {
        try{
            if ( gameCommand == "R" || gameCommand == "Q" ) {}
            else throw IllegalArgumentException("[ERROR] R(재시도) 또는 Q(종료)를 입력하셔야 합니다.")
        } catch (e: IllegalArgumentException) {
            println("[ERROR] R(재시도) 또는 Q(종료)를 입력하셔야 합니다.")
            return false
        }catch (e: NullPointerException) {
            println("[ERROR] R(재시도) 또는 Q(종료)를 입력하셔야 합니다.")
            return false
        }
        return true
    }

}