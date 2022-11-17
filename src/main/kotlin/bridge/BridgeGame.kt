package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
enum class RequestType() {
    LAUNCH, MOVE, RETRY, INIT, NOW_STATE_MESSAGE, NONE;
}

class BridgeGame() {
    private var responseMessageQueue: ArrayDeque<ResponsePacket> = ArrayDeque()
    private var bridgeChecker: BridgeChecker? = null

    fun respondToRequest(request: RequestType, how: String = ""): ResponsePacket {
        when (how) {
            "" -> acceptRequest(request)
            else -> acceptRequest(request, how)
        }

        return responseMessageQueue.removeFirst()
    }

    private fun acceptRequest(request: RequestType) { // 변경 요청
        when (request) {
            RequestType.NOW_STATE_MESSAGE -> return
            RequestType.LAUNCH -> launchGame()
            else -> throw IllegalArgumentException("[ERROR] $request -> 처리할 수 없는 요청입니다")
        }
    }

    private fun acceptRequest(request: RequestType, how: String) { // 변경 요청
        return when (request) {
            RequestType.MOVE -> updateWithMove(how)
            RequestType.INIT -> initBridgeChecker(how)
            RequestType.RETRY -> updateWithRetry(how)
            else -> throw IllegalArgumentException("[ERROR] $request -> 처리할 수 없는 요청입니다")
        }
    }

    private fun launchGame() {
        val responsePacket1 = ResponsePacket(BridgeGameMessages.GUID_GAME_START_MESSAGE, RequestType.NOW_STATE_MESSAGE)
        responseMessageQueue.addLast(responsePacket1)
        val responsePacket2 = ResponsePacket(BridgeGameMessages.INPUT_LENGTH_OF_BRIDGE, RequestType.INIT)
        responseMessageQueue.addLast(responsePacket2)
    }

    private fun initBridgeChecker(how: String) {
        validateRequestInit(how)
        val size = how.toInt()
        bridgeChecker = BridgeChecker(size, BridgeMaker(BridgeRandomNumberGenerator()))

        val responsePacket = ResponsePacket(BridgeGameMessages.INPUT_TYPE_OF_MOVEMENT, RequestType.MOVE)
        responseMessageQueue.addLast(responsePacket)
    }

    private fun updateWithMove(how: String) {
        val result = move(how)

        val responsePacket1 = ResponsePacket(bridgeChecker!!.toStringOpenPart(), RequestType.NOW_STATE_MESSAGE)
        responseMessageQueue.add(responsePacket1)

        if (result[0] && !result[1]) {
            val responsePacket2 = ResponsePacket(BridgeGameMessages.INPUT_TYPE_OF_MOVEMENT, RequestType.MOVE)
            responseMessageQueue.add(responsePacket2)
        } else if (result[0] && result[1]) {
            val responsePacket2 = ResponsePacket(
                BridgeGameMessages.GUID_FINAL_GAME_RESULT + "\n" +
                        bridgeChecker!!.toStringOpenPart() + "\n\n" +
                        BridgeGameMessages.GUID_GAME_IS_SUCESSFUL + "\n" +
                        BridgeGameMessages.GUID_TOTAL_TRY_COUNT + "1", RequestType.NONE
            )
            responseMessageQueue.add(responsePacket2)
        } else {
            val responsePacket2 = ResponsePacket(BridgeGameMessages.INPUT_TYPE_OF_RETRY, RequestType.RETRY)
            responseMessageQueue.add(responsePacket2)
        }

    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private fun move(how: String): List<Boolean> {
        validateMoveRequest(how)
        return bridgeChecker!!.checkWithUpdating(how)
    }

    private fun updateWithRetry(how: String) {
        if (how == "R") {
            retry()
            val responsePacket = ResponsePacket(BridgeGameMessages.INPUT_TYPE_OF_MOVEMENT, RequestType.MOVE)
            responseMessageQueue.addLast(responsePacket)
        } else if (how == "Q") {

            val responsePacket1 = ResponsePacket(
                BridgeGameMessages.GUID_FINAL_GAME_RESULT + "\n" +
                        bridgeChecker!!.toStringOpenPart() + "\n\n" +
                        BridgeGameMessages.GUID_GAME_IS_SUCESSFUL + "\n" +
                        BridgeGameMessages.GUID_TOTAL_TRY_COUNT + "1", RequestType.NONE
            )

            responseMessageQueue.addLast(responsePacket1)
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private fun retry() {
        bridgeChecker!!.resetBridgeRevealed()
    }

    private fun updateState(string: String) {

    }

    private fun validateRequestInit(how: String) {
        try {
            val size = how.toInt()
            if (size < 3 || size > 20) throw IllegalArgumentException("[ERROR] Bridge size(= $size)가 정해진 범위를 벗어납니다")
        } catch (e: NumberFormatException) {
            throw NumberFormatException("[ERROR] $how -> Bridge를 초기화 하기 위해 정수를 입력해야 하는데 정수 형식을 지키지 않았습니다")
        }
    }

    private fun validateMoveRequest(how: String) {
        if (bridgeChecker == null) throw NullPointerException("[ERROR] 도로를 초기화하지 않았는데 MOVE 요청을 받았습니다")
        if (how != "U" && how != "D") throw IllegalArgumentException("[ERROR] $how -> 올바른 MOVE 요청이 아닙니다")
    }
}
