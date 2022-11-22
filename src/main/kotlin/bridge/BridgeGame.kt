package bridge

import bridge.exceptions.InvalidRangeException
import bridge.exceptions.InvalidRequestException
import bridge.exceptions.NullBridgeException
import bridge.exceptions.RequestFormatException
import bridge.strings.BridgeGameErrorMessages
import bridge.strings.BridgeGameMessages
import com.sun.net.httpserver.Authenticator.Retry

enum class RequestType {
    LAUNCH, MOVE, RETRY, INIT, GUID_MESSAGE, NONE;
}

/**
 * 다리 건너기 게임을 관리하는 클래스
 * BridgeGame를 사용하기 위해서는 정의된 RequestType을 사용해야 한다
 */
class BridgeGame {
    private var responseMessageQueue: ArrayDeque<ResponsePacket> = ArrayDeque()
    private var bridgeChecker: BridgeChecker? = null
    private var lastResponsePacket: ResponsePacket? = null

    fun respondToRequest(request: RequestType, how: String = ""): ResponsePacket {
        validateRequest(request)
        when (how) {
            "" -> acceptRequest(request)
            else -> acceptRequest(request, how)
        }
        lastResponsePacket = responseMessageQueue.removeFirst()
        return lastResponsePacket!!
    }

    private fun acceptRequest(request: RequestType) {
        when (request) {
            RequestType.GUID_MESSAGE -> return
            RequestType.LAUNCH -> launchGame()
            else -> throw IllegalArgumentException(BridgeGameErrorMessages.INVALID_REQUEST.message)
        }
    }

    private fun acceptRequest(request: RequestType, how: String) {
        when (request) {
            RequestType.MOVE -> updateWithMove(how)
            RequestType.RETRY -> updateWithRetry(how)
            RequestType.INIT -> initBridgeChecker(how)
            else -> throw IllegalArgumentException(BridgeGameErrorMessages.INVALID_REQUEST.message)
        }
    }

    private fun launchGame() {
        val responsePacket1 =
            ResponsePacket(BridgeGameMessages.GUID_GAME_START_MESSAGE.message, RequestType.GUID_MESSAGE)
        val responsePacket2 = ResponsePacket(BridgeGameMessages.INPUT_LENGTH_OF_BRIDGE.message, RequestType.INIT)
        responseMessageQueue.addLast(responsePacket1)
        responseMessageQueue.addLast(responsePacket2)
    }

    private fun initBridgeChecker(how: String) {
        validateRequestInit(how)

        val size = how.toInt()
        bridgeChecker = BridgeChecker(size, BridgeMaker(BridgeRandomNumberGenerator()))

        val responsePacket = ResponsePacket(BridgeGameMessages.INPUT_TYPE_OF_MOVEMENT.message, RequestType.MOVE)
        responseMessageQueue.addLast(responsePacket)
    }

    private fun updateWithMove(how: String) {
        val movedResult = move(how)

        val responsePackets = makeResponsePacketsByMovedResult(movedResult)
        for (packet in responsePackets) {
            responseMessageQueue.addLast(packet)
        }
    }

    private fun makeResponsePacketsByMovedResult(movedResult: List<Boolean>): List<ResponsePacket> {
        val result = mutableListOf<ResponsePacket>()
        result.add(ResponsePacket(bridgeChecker!!.toVisualizationOpenedPart(), RequestType.GUID_MESSAGE))
        // 0번 -> 마지막 블록이 정답으로 체크되었는지 여부, 1번 -> 마지막 블록까지 진행했는지 여부
        if (movedResult[0] && !movedResult[1])
            result.add(ResponsePacket(BridgeGameMessages.INPUT_TYPE_OF_MOVEMENT.message, RequestType.MOVE))
        else if (movedResult[0] && movedResult[1])
            result.add(ResponsePacket(bridgeChecker!!.toVisualizationGameResult(), RequestType.NONE))
        else if (!movedResult[0])
            result.add(ResponsePacket(BridgeGameMessages.INPUT_TYPE_OF_RETRY.message, RequestType.RETRY))
        return result
    }

    private fun updateWithRetry(how: String) {
        retry(how)
        if (how == CMD_RETRY) {
            val responsePacket = ResponsePacket(BridgeGameMessages.INPUT_TYPE_OF_MOVEMENT.message, RequestType.MOVE)
            responseMessageQueue.addLast(responsePacket)
            return
        }
        if (how == CMD_QUIT) {
            val responsePacket = ResponsePacket(bridgeChecker!!.toVisualizationGameResult(), RequestType.NONE)
            responseMessageQueue.addLast(responsePacket)
        }
    }

    private fun move(how: String): List<Boolean> {
        validateMoveRequest(how)
        return bridgeChecker!!.checkWithUpdating(how)
    }

    private fun retry(how: String) {
        validateRetry(how)
        if (how == CMD_RETRY)
            bridgeChecker!!.resetBridgeRevealed()
    }

    private fun validateRetry(how: String) {
        if (how != CMD_RETRY && how != CMD_QUIT)
            throw RequestFormatException(BridgeGameErrorMessages.INVALID_RETRY_REQUEST.message)
        if (bridgeChecker == null)
            throw NullBridgeException(BridgeGameErrorMessages.NULL_BRIDGE_RETRY_EXCEPTION.message)
    }

    private fun validateRequestInit(how: String) {
        try {
            val size = how.toInt()
            if (size < SIZE_MIN || size > SIZE_MAX) throw InvalidRangeException(BridgeGameErrorMessages.INVALID_BRIDGE_SIZE.message)
        } catch (e: NumberFormatException) {
            throw RequestFormatException(BridgeGameErrorMessages.NUMBER_FORMAT_EXCEPTION.message)
        }
    }

    private fun validateMoveRequest(how: String) {
        if (bridgeChecker == null)
            throw NullPointerException(BridgeGameErrorMessages.NULL_BRIDGE_CHECKER_MOVE_EXCEPTION.message)
        if (how != DIRECTION_UP && how != DIRECTION_DOWN)
            throw RequestFormatException(BridgeGameErrorMessages.INVALID_MOVE_REQUEST.message)
    }

    private fun validateRequest(request: RequestType) {
        if (lastResponsePacket == null) when (request) {
            RequestType.LAUNCH -> return
            else -> throw InvalidRequestException(BridgeGameErrorMessages.INVALID_REQUEST_NOT_STARTED.message)
        }
        else if (lastResponsePacket!!.popAdditionalMessage() != request) throw InvalidRequestException(BridgeGameErrorMessages.INVALID_REQUEST.message)
    }

    companion object {
        const val DIRECTION_UP = "U"
        const val DIRECTION_DOWN = "D"
        const val CMD_QUIT = "Q"
        const val CMD_RETRY = "R"
        const val SIZE_MIN = 3
        const val SIZE_MAX = 20
    }
}

