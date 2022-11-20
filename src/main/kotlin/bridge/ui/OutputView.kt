package bridge.ui

import bridge.utils.*

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    private var map = mutableListOf("[ ]", "[ ]")

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(column: Int, actual: String, predict: String): List<String> {
        if(column == 0){
            val index = 1
            if(actual == UP) {
                if(actual == predict){
                    map[0] = insertAtIndex(map[0], CORRECT, index)
                    map[1] = insertAtIndex(map[1], "  ", index)
                }else{
                    map[0] = insertAtIndex(map[0], "  ", index)
                    map[1] = insertAtIndex(map[1], INCORRECT, index)
                }
            }else {
                if(actual == predict) {
                    map[0] = insertAtIndex(map[0], "  ", index)
                    map[1] = insertAtIndex(map[1], CORRECT, index)
                }else{
                    map[0] = insertAtIndex(map[0], INCORRECT, index)
                    map[1] = insertAtIndex(map[1], "  ", index)
                }
            }
        }else{
            val index = 4 * column - 1
            if(actual == UP) {
                if(actual == predict){
                    map[0] = insertAtIndex(map[0], PARTITION, index)
                    map[0] = insertAtIndex(map[0], CORRECT, index + 2)
                    map[1] = insertAtIndex(map[1], PARTITION, index)
                    map[1] = insertAtIndex(map[1], "  ", index + 2)
                }else{
                    map[0] = insertAtIndex(map[0], PARTITION, index)
                    map[0] = insertAtIndex(map[0], "  ", index + 2)
                    map[1] = insertAtIndex(map[1], PARTITION, index)
                    map[1] = insertAtIndex(map[1], INCORRECT, index + 2)
                }
            }else {
                if(actual == predict) {
                    map[0] = insertAtIndex(map[0], PARTITION, index)
                    map[0] = insertAtIndex(map[0], "  ", index + 2)
                    map[1] = insertAtIndex(map[1], PARTITION, index)
                    map[1] = insertAtIndex(map[1], CORRECT, index + 2)
                }else{
                    map[0] = insertAtIndex(map[0], PARTITION, index)
                    map[0] = insertAtIndex(map[0], INCORRECT, index + 2)
                    map[1] = insertAtIndex(map[1], PARTITION, index)
                    map[1] = insertAtIndex(map[1], "  ", index + 2)
                }
            }
        }

        return map
    }

    private fun insertAtIndex(original: String, str: String, position: Int): String {
        val sb = StringBuilder(original)
        sb.insert(position, str)
        return sb.toString()
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(map: List<String>, result: String, tryNumber: Int) {
        println(FINAL_MAP_MSG)
        println(map)
        println(FINAL_RESULT_MSG + result)
        println(FINAL_TRY_NUM_MSG + tryNumber)
    }
}
