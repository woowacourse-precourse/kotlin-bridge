package bridge

import com.sun.source.tree.TryTree

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(bridge: List<String>, mybridge: List<String>) {
        val temp1 = makeMap(bridge, mybridge, "U")
        val temp2 = makeMap(bridge, mybridge, "D")

        if(temp1 != 0 || temp2 != 0){
            count++
            BridgeGame().retry(bridge, mybridge)
        }
    }

    fun makeMap(bridge: List<String>, mybridge: List<String>, updown: String): Int {
        var temp = "["
        var num = 0

        for (i in 0 until mybridge.size - 1) {
            if (updown == mybridge[i] && bridge[i] == mybridge[i]) temp += " O |"
            if (updown != mybridge[i]) temp += "   |"
        }

        if (updown == mybridge[mybridge.size - 1] && bridge[mybridge.size - 1] == mybridge[mybridge.size - 1]) temp += " O ]"
        if (updown == mybridge[mybridge.size - 1] && bridge[mybridge.size - 1] != mybridge[mybridge.size - 1]) {
            temp += " X ]"
            num++
        }
        if (updown != mybridge[mybridge.size - 1]) temp += "   ]"

        println(temp)
        return num
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(bridge: List<String>, mybridge: List<String>) {
        if(check == 0) {
            println("최종 게임 결과")
            val temp1 = makeMap(bridge, mybridge, "U")
            val temp2 = makeMap(bridge, mybridge, "D")
            var result = "성공"

            if (temp1 != 0 || temp2 != 0) result = "실패"
            println("게임 성공 여부: $result")
            println("총 시도한 횟수: $count")
        }
        check = 1
    }
}
