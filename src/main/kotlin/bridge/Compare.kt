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
            //유저가 이동 성공했고 위쪽일 때
        }
        if(userMove == "D") {
            //유저가 이동 성공했고 아래쪽일 때
        }
    }

    private fun checkIsUpperOrDownOnFail(userMove : String) {
        if (userMove == "U") {
            //유저가 이동 실패했고 위쪽일 때
        }
        if(userMove == "D") {
            //유저가 이동 실패했고 아래쪽일 때
        }
    }
}