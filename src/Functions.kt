import java.util.*

fun main(){
 println(whatShouldIDoToday("happy", "sunny"))
    val rollDice= { Random().nextInt(12) + 1}
    val rollDice1= {sides : Int -> if (sides == 0)0 else Random().nextInt(sides) + 1}
    val rollDice2: (Int) -> Int = { sides -> if (sides == 0)0 else Random().nextInt(sides) + 1}
    gamePlay(rollDice2(4))

}

fun gamePlay(diceRoll: Int){
    println(diceRoll)
}

fun whatShouldIDoToday(mood: String, weather: String = "sunny", temperature: Int = 24): String {
    return when {
        mood == "happy" && weather == "sunny" -> "go for a walk"
        mood == "sad" && weather == "rainy" && temperature == 0 -> "stay in bed"
        temperature > 35 -> "go swimming"
        else -> "Stay home and read."
    }

}