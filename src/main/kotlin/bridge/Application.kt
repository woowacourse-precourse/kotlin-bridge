package bridge

import model.BridgeGame
import java.util.StringJoiner
import javax.print.DocFlavor.STRING

fun main() {
    // 다리 건너기 게임을 시작합니다.
    view.OutputView().printGameStart()

    // 다리의 길이를 입력해주세요.
    view.OutputView().printBridgeLen()
    val bridgeSize = view.InputView().readBridgeSize()
    println()

    val bridge = BridgeMaker(BridgeRandomNumberGenerator()) // 상속과 반환!? : 뒤에?!
    var answerMove = bridge.makeBridge(bridgeSize) // [U, D, U] 이런 식으로 현재 리스트가 만들어짐
    println(answerMove)
    val originAnswerMove = answerMove
    var trialCount = 1
    val moveHashmapList = MutableList(bridgeSize) { it -> HashMap<String, String>() }
    var totalMovePath = mutableListOf<String>("", "")

    // 여기부터가 새롭게 반복되는 구간
    while (true) {
        // TODO(): 게임 진행
        // 이동할 칸을 선택해주세요.
        view.OutputView().printMoveTarget()
        val moveInput = view.InputView().readMoving()
        var flag = true
        // 인풋을 받아서 결과를 도출하는 함수
        val resultMoveHashmap = BridgeGame().move(moveInput, answerMove)
        answerMove = answerMove.slice(1 until answerMove.size)
        println(answerMove)
        println("resultMoveHashmap: $resultMoveHashmap")

        moveHashmapList[trialCount - 1] = resultMoveHashmap
        println("moveHashmapList: ${moveHashmapList}")

        if (resultMoveHashmap.containsValue("X")) {
//            if (trialCount == 1) {
//                view.OutputView().printSingleResult(moveHashmapList)
//            }
            totalMovePath = view.OutputView().printMap(trialCount, moveHashmapList)
            println(totalMovePath[0])
            println(totalMovePath[1])
            flag = BridgeGame().retry()
            continue
        }

        // 그다음에 종료 체크
        if (!flag) {
            answerMove = originAnswerMove
            break
        }

        // 그 결과를 프린트 하는 함수
//        if (trialCount == 1) {
//            println("trialCount: $trialCount")
//            view.OutputView().printSingleResult(moveHashmapList)
//            // 횟수 늘리기
//            trialCount += 1
//            continue
//        }
        totalMovePath = view.OutputView().printMap(trialCount, moveHashmapList)
        println(totalMovePath[0])
        println(totalMovePath[1])

        if (trialCount == bridgeSize) {
            answerMove = originAnswerMove
            break
        }
        // 횟수 늘리기
        trialCount += 1
    }
    // 최종 게임 결과
    view.OutputView().printResultFinalGame()
//    view.OutputView().printSingleResult(moveHashmapList)
//    view.OutputView().printResult(trialCount, moveHashmapList)
    totalMovePath = view.OutputView().printMap(trialCount, moveHashmapList)
    println(totalMovePath[0])
    println(totalMovePath[1])

    // 게임 성공 여부 및 시도 회수
    view.OutputView().printCheckSuccessGame()
    view.OutputView().printNumTotalTrial()
}
