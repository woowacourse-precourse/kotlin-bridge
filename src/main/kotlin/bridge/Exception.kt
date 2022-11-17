package bridge

class Exception {
    companion object {
        fun validateNumber(readLine: String) = require(readLine.matches(Regex("\\d+"))) {
            println("[ERROR] 숫자만 입력 가능합니다.")
        }
        fun validateSizeRange(readLine: Int) = require(readLine in 3..20) {
            println("[ERROR] 3-20 사이의 숫자만 입력 가능합니다.")
        }

        fun validateDirectionRange(readLine: String) = require(readLine in listOf("U", "D")) {
            println("[ERROR] 위(U)나 아래(D)만 입력 가능합니다.")
        }

        fun validateRestartRange(readLine: String) = require(readLine in listOf("R", "Q")) {
            println("[ERROR] 재시작(R)이나 종료(Q)만 입력 가능합니다.")
        }
    }
}