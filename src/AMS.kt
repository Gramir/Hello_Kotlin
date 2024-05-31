import java.util.*

fun main(args: Array<String>){
    helloWorld()
    dayOfWeek()
    getFortuneCookie()
}

fun helloWorld(){
    println("Hello World")
}

fun dayOfWeek(){
    println("What day is it today?")
    Calendar.getInstance().get(Calendar.DAY_OF_WEEK).also {
        println(when(it){
            1 -> "Sunday"
            2 -> "Monday"
            3 -> "Tuesday"
            4 -> "Wednesday"
            5 -> "Thursday"
            6 -> "Friday"
            7 -> "Saturday"
            else -> "Time has stopped"
        })
    }
}

fun getFortuneCookie(): String {
    val fortunes = listOf("You will have a great day!", "Things will go well for you today.", "Enjoy a wonderful day of success.", "Be humble and all will turn out well.", "Today is a good day for exercising restraint.", "Take it easy and enjoy life!", "Treasure your friends because they are your greatest fortune.")
    print("Enter your birthday: ")
    val birthday = readLine()?.toIntOrNull() ?: 1
    return fortunes[birthday.rem(fortunes.size)]
    //for (i in 1..10) {
    //    val fortune = getFortuneCookie()
    //    println("\nYour fortune is: $fortune")
    //    if (fortune.contains("Take it easy")) break
}