package bridge

import javax.swing.text.html.HTML.Tag.U

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(bridgeGame: BridgeGame) {

        val inputList:List<String> = bridgeGame.inputList
        val answerList:List<String> = bridgeGame.answerList

        var upperList = mutableListOf<String>()
        var lowerList = mutableListOf<String>()


        for(i in inputList.indices){
            if(inputList[i] == answerList[i] && inputList[i] == "U"){
                upperList.add("O")
                lowerList.add(" ")
            }
            if(inputList[i] == answerList[i] && inputList[i] == "D"){
                upperList.add(" ")
                lowerList.add("O")
            }
            if(inputList[i] != answerList[i] && inputList[i] == "U"){
                upperList.add("X")
                lowerList.add(" ")
            }
            if(inputList[i] != answerList[i] && inputList[i] == "D"){
                upperList.add(" ")
                lowerList.add("X")
            }

        }

        println(upperList.joinToString(" | ", "[ ", " ]"))
        println(lowerList.joinToString(" | ", "[ ", " ]"))

    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(bridgeGame: BridgeGame) {



        println("최종 게임 결과")
        printMap(bridgeGame)
        println("")

        println("게임 성공 여부: ${if(bridgeGame.success == 1){"성공"}else{"실패"}}")
        println("총 시도한 횟수: ${bridgeGame.count}")

        //최종 게임 결과
        //[ O |   |   ]
        //[   | O | O ]

        //게임 성공 여부: 성공
        //총 시도한 횟수: 2

    }
}
