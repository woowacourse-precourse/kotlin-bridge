package view

import util.Game

class OutputView {

    fun printMap(resultBridge: MutableList<Pair<String, String>>) {
        printUpLine(resultBridge)
        printDownLine(resultBridge)
    }
    
    fun printResult(resultBridge: MutableList<Pair<String, String>>) {
        println(Game.RESULT.message)
        printUpLine(resultBridge)
        printDownLine(resultBridge)
    }

    private fun printUpLine(resultBridge: MutableList<Pair<String, String>>){
        var i = 0
        print("[")
        resultBridge.forEach { (first, second) ->
            if (first == "U") {
                print(" $second")
            } else {
                print("  ")
            }
            i++
            if(i != resultBridge.size){
                print(" |")
            }
        }
        println(" ]")
    }

    private fun printDownLine(resultBridge: MutableList<Pair<String, String>>) {
        var i = 0
        print("[")
        resultBridge.forEach { (first, second) ->
            if (first == "D") {
                print(" $second")
            } else {
                print("  ")
            }
            i++
            if(i != resultBridge.size){
                print(" |")
            }
        }
        println(" ]")
    }
}
