package view

import data.BridgeStore.BRIDGE_DOWN
import data.BridgeStore.BRIDGE_END
import data.BridgeStore.BRIDGE_MID
import data.BridgeStore.BRIDGE_UP
import data.BridgeStore.BRIDGE_START
import data.BridgeStore.FAIL
import data.BridgeStore.FINAL_RESULT
import data.BridgeStore.INPUT_BRIDGE_LENGTH
import data.BridgeStore.MOVE_BRIDGE
import data.BridgeStore.RETRY_GAME
import data.BridgeStore.SPACE
import data.BridgeStore.START_GAME
import data.BridgeStore.SUCCESS
import data.BridgeStore.SUCCESS_GAME_CHECK
import data.BridgeStore.TRY_COUNT
import data.BridgeStore.USER_ALIVE
import data.BridgeStore.USER_DIE

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {

    fun printMap(bridge: List<String>, input: List<String>) {
        printUpDecide(bridge, input)
        println()
        printDownDecide(bridge, input)
        println("\n")
    }

    private fun printDownDecide(bridge: List<String>, input: List<String>) {
        print(BRIDGE_START)
        input.forEachIndexed { idx, value ->
            val decide = checkDownDecide(idx, value, bridge)
            print(" $decide ")
            if (idx != input.size - 1) print(BRIDGE_MID)
        }
        print(BRIDGE_END)
    }

    private fun printUpDecide(bridge: List<String>, input: List<String>) {
        print(BRIDGE_START)
        input.forEachIndexed { idx, value ->
            val decide = checkUpDecide(idx, value, bridge)
            print(" $decide ")
            if (idx != input.size - 1) print(BRIDGE_MID)
        }
        print(BRIDGE_END)
    }

    private fun checkDownDecide(idx: Int, value: String, bridge: List<String>): String {
        when {
            value == BRIDGE_DOWN && value == bridge[idx] -> return USER_ALIVE
            value == BRIDGE_DOWN && value != bridge[idx] -> return USER_DIE
        }
        return SPACE
    }

    private fun checkUpDecide(idx: Int, value: String, bridge: List<String>): String {
        when {
            value == BRIDGE_UP && value == bridge[idx] -> return USER_ALIVE
            value == BRIDGE_UP && value != bridge[idx] -> return USER_DIE
        }
        return SPACE
    }

    fun printResult() = println(FINAL_RESULT)

    fun printStartGame() = println(START_GAME)

    fun printInputBridgeLength() = println(INPUT_BRIDGE_LENGTH)

    fun printMoveBridge() = println(MOVE_BRIDGE)

    fun printRetryGame() = println(RETRY_GAME)

    fun printGameSuccess(isSuccess: Boolean) {
        var result = FAIL
        if (isSuccess) result = SUCCESS
        println("$SUCCESS_GAME_CHECK $result")
    }

    fun printTryCount(count: Int) = println("$TRY_COUNT $count")
}
