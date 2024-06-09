package spices

enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF),
    YELLOW(0xFFFF00),
    WHITE(0xFFFFFF)
}

interface SpiceColor {
    val color: Color
}

object YellowSpiceColor : SpiceColor {
    override val color: Color = Color.YELLOW
}

sealed class Spice(val name: String, val spiciness: String, override val color: SpiceColor) : SpiceColor {

    val heat: Int
        get() = when (spiciness.toLowerCase()) {
            "mild" -> 1
            "medium" -> 3
            "spicy" -> 5
            "very spicy" -> 7
            "extremely spicy" -> 10
            else -> 0
        }

    init {
        println("Spice created: $name, spiciness level: $spiciness, heat: $heat, color: ${color.color}")
    }

    abstract fun prepareSpice()
}

interface Grinder {
    fun grind()
}

class Curry(name: String, spiciness: String, color: SpiceColor = YellowSpiceColor) : Spice(name, spiciness, color), Grinder {

    override fun prepareSpice() {
        println("Preparing spice: $name")
        grind()
    }

    override fun grind() {
        println("Grinding $name into powder")
    }
}

fun makeSalt(): Spice {
    return object : Spice("Salt", "mild", object : SpiceColor {
        override val color: Color = Color.WHITE
    }) {
        override fun prepareSpice() {
            println("Preparing spice: $name")
        }
    }
}

data class SpiceContainer(val spice: Spice) {
    val label: String
        get() = spice.name
}

fun main() {
    val curry = Curry("Curry", "spicy")
    val salt = makeSalt()

    val containers = listOf(
        SpiceContainer(curry),
        SpiceContainer(Curry("Pepper", "very spicy")),
        SpiceContainer(Curry("Paprika", "medium")),
        SpiceContainer(Curry("Turmeric", "mild")),
        SpiceContainer(salt)
    )

    containers.forEach { container ->
        println("Spice container label: ${container.label}")
    }
}
