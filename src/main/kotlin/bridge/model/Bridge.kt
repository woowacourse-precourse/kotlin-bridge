package bridge.model

class Bridge(private val bridgeLaneShape: List<String>) {
    var laneCount = 0

    /**
     * 랜덤 생성한 다리 형태와 입력받은 이동 칸의 일치 여부를 boolean 으로 반환하는 함수
     */
    fun isLaneAvailable(inputMoveLaneSymbol: Char): Boolean{
        if (inputMoveLaneSymbol == bridgeLaneShape[0][laneCount]){
            laneCount += 1
            return true
        }
        laneCount += 1
        return false
    }
}
