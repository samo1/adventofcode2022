fun main() {
    // A for Rock, B for Paper, and C for Scissors
    // X for Rock, Y for Paper, and Z for Scissors
    fun part1(input: List<String>) = input.sumOf {
        val shapeScore = when (it[2]) {
            'X' -> 1
            'Y' -> 2
            'Z' -> 3
            else -> throw IllegalArgumentException("Invalid input '$it'")
        }
        val outcomeScore = when (it) {
            "A X" -> 3
            "A Y" -> 6
            "A Z" -> 0
            "B X" -> 0
            "B Y" -> 3
            "B Z" -> 6
            "C X" -> 6
            "C Y" -> 0
            "C Z" -> 3
            else -> throw IllegalArgumentException("Invalid input '$it'")
        }
        shapeScore + outcomeScore
    }

    // A for Rock, B for Paper, and C for Scissors
    // X means you need to lose, Y means you need to end the round in a draw, and Z means you need to win
    fun part2(input: List<String>) = input.sumOf {
        val myHand = when (it) {
            "A X" -> 'C'
            "A Y" -> 'A'
            "A Z" -> 'B'
            "B X" -> 'A'
            "B Y" -> 'B'
            "B Z" -> 'C'
            "C X" -> 'B'
            "C Y" -> 'C'
            "C Z" -> 'A'
            else -> throw IllegalArgumentException("Invalid input '$it'")
        }
        val shapeScore = when (myHand) {
            'A' -> 1
            'B' -> 2
            'C' -> 3
            else -> throw IllegalArgumentException("Invalid input '$it'")
        }
        val outcomeScore = when ("${it[0]} $myHand") {
            "A A" -> 3
            "A B" -> 6
            "A C" -> 0
            "B A" -> 0
            "B B" -> 3
            "B C" -> 6
            "C A" -> 6
            "C B" -> 0
            "C C" -> 3
            else -> throw IllegalArgumentException("Invalid input '$it'")
        }
        shapeScore + outcomeScore
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
