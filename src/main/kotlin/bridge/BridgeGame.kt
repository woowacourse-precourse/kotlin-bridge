package bridge

import camp.nextstep.edu.missionutils.Console


class BridgeGame {
    var userselectupdown = mutableListOf<String>()
    var inputview = InputView()

    fun move(a: String) {
        userselectupdown.add(a)
    }
    fun retry(){
        userselectupdown.clear()
        count+=1
    }
}
