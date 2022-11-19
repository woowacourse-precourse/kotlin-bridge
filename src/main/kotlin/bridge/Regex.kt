package bridge

import java.util.regex.Pattern

class Regex(private val userInput: String) {

    fun checkBridgeLengthRegexes() : Boolean {
        return try {
            checkItsNull(userInput)
            checkItsAllNumber(userInput)
            checkBridgeLengthInRange(userInput)
            true
        } catch (e : IllegalArgumentException) {
            false
        }
    }

    fun checkUserMovementRegexes() : Boolean {
        return try {
            checkItsNull(userInput)
            checkMoveIsInLength(userInput)
            checkMoveIsRight(userInput)
            true
        } catch (e : IllegalArgumentException) {
            false
        }
    }

    fun checkUserRetryRegexes() : Boolean {
        return try {
            checkItsNull(userInput)
            checkMoveIsInLength(userInput)
            checkRetryIsRight(userInput)
            true
        } catch (e : IllegalArgumentException) {
            false
        }
    }

    private fun checkItsNull(userInput: String) {
        if(userInput.isEmpty()) {
            PrintForm().printUserInputError(ErrorType.InputIsNull)
            throw IllegalArgumentException()
        }
    }

    private fun checkItsAllNumber(userInput: String) {
        if (!Pattern.matches("^[0-9]*$", userInput)) {
            PrintForm().printUserInputError(ErrorType.InputIncludeWords)
            throw IllegalArgumentException()
        }
    }

    private fun checkBridgeLengthInRange(userInput: String) {
        if(userInput.toInt() !in 3..20) {
            PrintForm().printUserInputError(ErrorType.BridgeLengthNotInRange)
            throw IllegalArgumentException()
        }
    }

    private fun checkMoveIsInLength(userMove : String) {
        if(userMove.length != 1) {
            PrintForm().printUserInputError(ErrorType.MovementInputShouldBeSingleLetter)
            throw IllegalArgumentException()
        }
    }

    private fun checkMoveIsRight(userMove : String) {
        when(userMove) {
            "U", "D" -> return
            else -> {
                PrintForm().printUserInputError(ErrorType.NotDefinedMovementInput)
                throw IllegalArgumentException()
            }
        }
    }

    private fun checkRetryIsRight (userRetry : String) {
        when(userRetry.toCharArray()[0].code) {
            in 81..82, in 113..114 -> return
            else -> {
                PrintForm().printUserInputError(ErrorType.NotDefinedRetryInput)
                throw IllegalArgumentException()
            }
        }
    }
}