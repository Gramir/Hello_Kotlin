import java.util.*

fun main(){
    helloWorld()
    dayOfWeek()
   // getBirthday()
    println( fitMoreFish(10.0, listOf(3,3,3)))
    println(fitMoreFish(8.0, listOf(2,2,2), hasDecorations = false))
    println(fitMoreFish(9.0, listOf(1,1,3), 3))
    println( fitMoreFish(10.0, listOf(), 7, true))

}

fun fitMoreFish(tankSize: Double, currentFish: List<Int>, fishSize: Int = 2, hasDecorations: Boolean = true): Boolean {
    return (tankSize * if (hasDecorations) 0.8 else 1.0) >= (currentFish.sum() + fishSize)
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



fun getBirthday() {
    print("Enter your birthday: ")
    val birthday= readlnOrNull()?.toIntOrNull() ?: 1
    println({getFortuneCookie(birthday)})
}

fun getFortuneCookie(birthday: Int): String {
    val fortunes = listOf(
        "You will have a great day!",
        "Things will go well for you today.",
        "Enjoy a wonderful day of success.",
        "Be humble and all will turn out well.",
        "Today is a good day for exercising restraint.",
        "Take it easy and enjoy life!",
        "Treasure your friends because they are your greatest fortune."
    )

    return fortunes[birthday.rem(fortunes.size)]
}