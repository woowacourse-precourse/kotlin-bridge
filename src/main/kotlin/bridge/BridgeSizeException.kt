package bridge

class BridgeSizeException(inputData: String) {
    init{
        isNotInteger(inputData)
        isNotBridgeNumber(inputData)
    }

    private fun isNotInteger(inputData: String) {
        if(!inputData.chars().allMatch { Character.isDigit(it) })
            throw IllegalArgumentException("[ERROR] 입력한 다리 길이는 정수가 아닙니다.")
    }

    private fun isNotBridgeNumber(inputData: String) {
        if(inputData.toInt() < 3 || inputData.toInt() > 20)
            throw IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.")
    }
}