fun main() {
    val options = arrayOf("Rock", "Paper", "Scissors")
    val gameChoice = getGameChoice(options)
    val userChoice = getUserChoice(options)
    println("You chose $userChoice. I chose $gameChoice. ${printResult(userChoice, gameChoice)}")
}

fun getGameChoice(optionsParam: Array<String>) =
    optionsParam[(Math.random() * optionsParam.size).toInt()]

fun getUserChoice(optionsParam: Array<String>): String {
    var isValidChoice = false
    var userChoice2 = ""
    while (!isValidChoice) {
        print("Please enter one of the following: ")
        for (item in optionsParam) print("$item ")
        println(".")
        val userInput = readlnOrNull()
        if (userInput != null && userInput in optionsParam) {
            isValidChoice = true
            userChoice2 = userInput
        }
        if (!isValidChoice) println("You must enter a valid choice!")
    }
    return userChoice2
}

fun printResult(userChoice: String, gameChoice: String): String {
    return if (userChoice == gameChoice) "Tie!"
    else if (
        (userChoice == "Rock" && gameChoice == "Scissors") ||
        (userChoice == "Scissors" && gameChoice == "Paper") ||
        (userChoice == "Paper" && gameChoice == "Rock")
    ) "You win!"
    else "You lose!"
}