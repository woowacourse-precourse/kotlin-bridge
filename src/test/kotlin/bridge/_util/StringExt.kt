package bridge._util

internal fun String.countOf(element: String, ignoreCase: Boolean = false): Int {
    var count = 0
    var index = 0

    do {
        index = indexOf(element, index, ignoreCase)
        if (index != -1) {
            index += 1
            count += 1
        }
    } while (index != -1)

    return count
}