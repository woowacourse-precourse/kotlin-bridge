package bridge

class Compare(private val upperList: MutableList<String>, private val downList: MutableList<String>) {

    fun checkIsSuccessOrFail(userMove: String, isSuccess: Boolean) : Boolean {
        return if(isSuccess) {
            checkIsUpperOrDownOnSuccess(userMove)
            true
        } else {
            checkIsUpperOrDownOnFail(userMove)
            false
        }
    }

    private fun checkIsUpperOrDownOnSuccess(userMove : String) {
        if (userMove == "U") {
            actWhenSuccessUpper()
        }
        if(userMove == "D") {
            actWhenSuccessDown()
        }
        OutputView(upperList, downList).printMap()
    }

    private fun checkIsUpperOrDownOnFail(userMove : String) {
        if (userMove == "U") {
            actWhenFailUpper()
        }
        if(userMove == "D") {
            actWhenFailDown()
        }
        OutputView(upperList, downList).printMap()
    }

    private fun actWhenSuccessUpper() {
        addListSuccess(upperList)
        addListOnNull(downList)
    }

    private fun actWhenSuccessDown() {
        addListSuccess(downList)
        addListOnNull(upperList)
    }

    private fun actWhenFailUpper() {
        addListFail(upperList)
        addListOnNull(downList)
    }

    private fun actWhenFailDown() {
        addListFail(downList)
        addListOnNull(upperList)
    }

    private fun addListSuccess(list : MutableList<String>) {
        list.add("O")
    }

    private fun addListFail(list : MutableList<String>) {
        list.add("X")
    }

    private fun addListOnNull(list : MutableList<String>) {
        list.add(" ")
    }
}