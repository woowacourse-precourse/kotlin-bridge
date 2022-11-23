package bridge

class Exception(var input: String) {
    // [다리] size 정수 체크
    fun checkInteger(): Boolean {
        return try {
            input.toInt()
            true
        } catch (e: IllegalArgumentException) {
            printError(BridgeSizeErrorState.INTEGER.message)
            false
        }
    }
    // [다리] 3~20까지 범위 체크
    fun checkRange(): Boolean {
        var intInput = input.toInt()
        return try {
            require(intInput in 3..20)
            true
        } catch (e: IllegalArgumentException) {
            printError(BridgeSizeErrorState.RANGE.message)
            false
        }
    }
    // [String] 한 글자 체크 ex) U/D/R/Q
    fun checkOverLength(): Boolean {
        return try {
            require(input.length in 0..1)
            true
        } catch (e: IllegalArgumentException) {
            printError(PlayErrorState.SIZE.message)
            false
        }
    }
    // 공백 입력 체크
    fun checkLessLength(): Boolean {
        return try {
            require(input.isNotEmpty())
            true
        } catch (e: IllegalArgumentException) {
            printError(PlayErrorState.ZERO.message)
            false
        }
    }
    //String 체크
    fun isString(): Boolean {
        return try {
            require(input.elementAt(0) in 'A'..'Z' || input.elementAt(0) in 'a'..'z')
            true
        } catch (e: IllegalArgumentException) {
            printError(PlayErrorState.STRING.message)
            false
        }
    }
    // 대문자인지  체크
    fun checkUpperCase(): Boolean {
        return try {
            require(input == input.uppercase())
            true
        } catch (e: IllegalArgumentException) {
            printError(PlayErrorState.UPPERCASE.message)
            false
        }
    }
    // U/D 체크
    fun checkDirection(): Boolean {
        return try {
            require(input == "U" || input == "D")
            true
        } catch (e: IllegalArgumentException) {
            printError(PlayErrorState.CHOICE.message)
            false
        }
    }
    // R/Q 체크
    fun checkDecision(): Boolean {
        return try {
            require(input == "R" || input == "Q")
            true
        } catch (e: IllegalArgumentException) {
            printError(PlayErrorState.OVER.message)
            false
        }
    }
    // 서두에 [ERROR] 붙이기
    private fun printError(message: String) {
        val errorIntro = "[ERROR] "
        println(errorIntro + message)
    }
    
    //다리 size 입력 멘트
    enum class BridgeSizeErrorState(val message: String) {
        INTEGER("다리 길이에 정수가 아닌 수는 포함 할 수 없습니다."),
        RANGE("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }
    //이동 및 게임 진행여부 멘트
    enum class PlayErrorState(val message: String) {
        ZERO("문자를 하나 이상 입력해 주세요."),
        SIZE("두 개 이상의 글자는 입력 할 수 없습니다."),
        STRING("문자만 입력 해 주세요."),
        CHOICE("U(위), D(아래)로만 다음 칸을 선택 할 수 있습니다."),
        OVER("재시도: R, 종료: Q 중에서 선택 해 주세요."),
        UPPERCASE("대문자로 입력 해 주세요.");
    }
}
