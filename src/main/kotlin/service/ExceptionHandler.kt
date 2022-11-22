package service

import java.lang.IllegalArgumentException

object ExceptionHandler {
    fun checkValidMoving(location: String): Boolean {
        try {
            require(location == "U" || location == "D") { Message.InputViewEnum.INVALID_MOVE }
        } catch (e: IllegalArgumentException) {
            println(e)
            return false
        }
        return true
    }

    fun checkValidRestart(restart: String): Boolean {
        try {
            require(restart == "Q" || restart == "R") { Message.InputViewEnum.INVALID_RESTART }
        } catch (e: IllegalArgumentException) {
            println(e)
            return false
        }
        return true
    }

    fun checkValidState(state: Int) {
        try {
            require(state == 1 || state == 0) { Message.OutputViewEnum.INVALID_STATE }
        } catch (e: IllegalArgumentException) {
            print(e)
        }
    }

    fun checkValidRangeLength(size: Int): Boolean {
        try {
            require(size in 3..20) { Message.InputViewEnum.INVALID_LENGTH }
        } catch (e: IllegalArgumentException) {
            println(e)
            return false
        }
        return true
    }

    fun checkValidLength(size: String): Boolean {
        try {
            requireNotNull(size.toIntOrNull()) { Message.InputViewEnum.INVALID_LENGTH }
            require(size.toInt() in 3..20) { Message.InputViewEnum.INVALID_LENGTH }
        } catch (e: IllegalArgumentException) {
            println(e)
            return false
        }
        return true
    }
}