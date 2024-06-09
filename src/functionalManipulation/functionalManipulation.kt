package functionalManipulation

class Location(val x: Int, val y: Int)

class Game {
    private var currentLocation = Location(0, 0)

    private val mapSize = 4
    private val map = Array(mapSize) { Array<String?>(mapSize) { null } }

    init {
        map[0][0] = "You are at the starting point."
        map[1][1] = "You are at a crossroad."
        map[2][2] = "You are at a dead end."
        map[3][3] = "You have reached the destination."
    }

    fun move(where: () -> Boolean) {
        if (where()) {
            updateLocation()
            printLocationDescription()
        }
    }

    private fun updateLocation() {
        when {
            path.last() == Directions.NORTH -> currentLocation = Location((currentLocation.x - 1).coerceAtLeast(0), currentLocation.y)
            path.last() == Directions.SOUTH -> currentLocation = Location((currentLocation.x + 1).coerceAtMost(mapSize - 1), currentLocation.y)
            path.last() == Directions.WEST -> currentLocation = Location(currentLocation.x, (currentLocation.y - 1).coerceAtLeast(0))
            path.last() == Directions.EAST -> currentLocation = Location(currentLocation.x, (currentLocation.y + 1).coerceAtMost(mapSize - 1))
        }
    }

    private fun printLocationDescription() {
        println(map[currentLocation.x][currentLocation.y])
    }

    fun makeMove(direction: String?) {
        when (direction) {
            "n" -> move(north)
            "s" -> move(south)
            "e" -> move(east)
            "w" -> move(west)
            else -> move(end)
        }
    }

    companion object {
        private val path = mutableListOf(Directions.START)

        private val north: () -> Boolean = {
            path.add(Directions.NORTH)
            true
        }

        private val south: () -> Boolean = {
            path.add(Directions.SOUTH)
            true
        }

        private val east: () -> Boolean = {
            path.add(Directions.EAST)
            true
        }

        private val west: () -> Boolean = {
            path.add(Directions.WEST)
            true
        }

        private val end: () -> Boolean = {
            path.add(Directions.END)
            println("Game Over")
            println("Path: $path")
            path.clear()
            path.add(Directions.START)
            false
        }
    }
}

fun main() {
    val game = Game()

    while (true) {
        print("Enter a direction: n/s/e/w: ")
        val input = readLine()
        game.makeMove(input)
    }
}
