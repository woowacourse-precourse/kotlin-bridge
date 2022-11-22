package bridge.model

class Bridge(private val bridgeLaneShape: List<String>) {
    private var laneCount = 0

    /**
     * 랜덤 생성한 다리 형태와 입력받은 이동 칸의 일치 여부를 boolean 으로 반환하는 함수
     */
    fun isLaneAvailable(inputMoveLaneSymbol: String): Boolean{
        if (inputMoveLaneSymbol == bridgeLaneShape[laneCount]){
            laneCount += 1
            return true
        }
        laneCount += 1
        return false
    }

    /**
     * 다리 끝까지 이동했는지 판단하는 함수
     */
    fun isMoveUntilEnd(): Boolean {
        if (laneCount == bridgeLaneShape.size)
            return true
        return false
    }

    /**
     * 이동 칸 횟수를 초기화 해주는 함수
     */
    fun initializeLaneCount(){
        laneCount = 0
    }
}
