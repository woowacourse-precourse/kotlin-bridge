package bridge.strings

enum class BridgeGameMessages(val message: String) {
    GUID_GAME_START_MESSAGE("다리 건너기 게임을 시작합니다"),
    GUID_GAME_SUCCESSFUL("성공"),
    GUID_GAME_FAIL("실패"),
    GUID_GAME_IS_SUCCESS("게임 성공 여부: "),
    GUID_TOTAL_TRY_COUNT("총 시도한 횟수: "),
    GUID_FINAL_GAME_RESULT("최종 게임 결과"),
    INPUT_LENGTH_OF_BRIDGE("다리의 길이를 입력해주세요."),
    INPUT_TYPE_OF_MOVEMENT("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    INPUT_TYPE_OF_RETRY("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

    companion object {
        fun makeFinalMessage(gameResultVisualization: String, isSuccess: Boolean, totalTryCount: Int): String {
            val result = if (isSuccess) GUID_GAME_SUCCESSFUL.message else GUID_GAME_FAIL.message
            return """
${GUID_FINAL_GAME_RESULT.message}
$gameResultVisualization

${GUID_GAME_IS_SUCCESS.message}${result}
${GUID_TOTAL_TRY_COUNT.message}$totalTryCount
            """.trimIndent()
        }
    }
}

