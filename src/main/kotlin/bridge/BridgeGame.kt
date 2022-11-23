package bridge

class BridgeGame(val bridge: List<String>) {
    var countTry = 1 // 도전 횟수
    var myPicks = mutableListOf<String>() // 유저가 입력한 방향 값(U/D)
    var bridgeAnswer = mutableListOf<Boolean>() // 유저가 입력한 방향의 정답 유무(O==true, X==false)
    // 유저 오답지(U/D,true/false)
    private fun addAnswer(bridgeSquare: String, guess: Boolean) {
        when (guess) {
            true -> {
                myPicks.add(bridgeSquare);bridgeAnswer.add(guess)
            }
            false -> {
                myPicks.add(bridgeSquare);bridgeAnswer.add(guess)
            }
        }
    }
    // 재도전: 유저 입력값 및 정오표 모두 삭제 할 때 사용
    private fun clearAnswer() {
        myPicks.clear()
        bridgeAnswer.clear()
    }
    // bridge 초기값: 재귀를 위한 함수
    // move()는 요소가 계속 변하는 new bridge를 받기때문에 초기 bridge값을 가지고 있는 함수가 필요
    fun tryMove() {
        move(bridge)
    }
    /**
     * <정답 비교 로직 요약>
     *     1. copy bridge[0]과 유저 입력(U/D)비교
     *     2. 같다면 bridge[0] 삭제, 다르다면 종료
     *     3. 재귀로 반복
     * **/
    
    // 모두 맞춘지 여부 검사
    fun move(currentBridge: List<String>) {
        when {
            currentBridge.isNotEmpty() -> findAnswer(currentBridge, Controller().writeMoving())
            currentBridge.isEmpty() -> {
                Controller().readResult(myPicks, bridgeAnswer);Controller().doneGame(currentBridge.size, countTry)
            }
        }
    }
    // 입력값이 bridge[0]과 같을 때, 다를 때 분기하는 함수
    private fun findAnswer(currentBridge: List<String>, myPick: String) {
        if (currentBridge[0] == myPick) {
            updateBridge(currentBridge, myPick)
        } else {
            addAnswer(myPick, false)
            Controller().readCurrent(myPicks, bridgeAnswer)
            retry(currentBridge)
        }
    }
    // 1.복사 및 bridge[0]삭제
    // 2.정오표 저장
    // 3.정오표 시각화
    // 4.다시 move()실행
    private fun updateBridge(bridgeMaker: List<String>, myPick: String) {
        var newBridge = bridgeMaker.toMutableList()
        newBridge.removeAt(0)
        addAnswer(myPick, true)
        Controller().readCurrent(myPicks, bridgeAnswer)
        return move(newBridge)
    }
    // 게임이 끝났을 때 실행 (R/Q) : 멘트 및 정오표 시각화
    private fun retry(bridgeMaker: List<String>) {
        when (Controller().writeGameCommand()) {
            "R" -> {
                countTry++; clearAnswer(); tryMove()
            }
            "Q" -> {
                Controller().readResult(myPicks, bridgeAnswer); Controller().doneGame(bridgeMaker.size, countTry)
            }
        }
    }
}
