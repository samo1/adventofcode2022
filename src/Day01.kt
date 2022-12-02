import java.util.PriorityQueue

fun main() {
    fun inputToCaloriesPerElf(input: List<String>): List<Int> {
        val calories = mutableListOf<Int>()
        var value = 0
        input.forEach { line ->
            if (line.trim() != "") {
                value += line.toInt()
            } else {
                calories.add(value)
                value = 0
            }
        }
        if (value != 0) {
            calories.add(value)
        }
        return calories
    }

    fun part1(input: List<String>): Int {
        val calories = inputToCaloriesPerElf(input)
        return calories.max()
    }

    fun part2(input: List<String>): Int {
        val calories = inputToCaloriesPerElf(input)
        val priorityQueue = PriorityQueue<Int>(calories.size, Comparator.reverseOrder())
        priorityQueue.addAll(calories)
        val elf1 = priorityQueue.poll()
        val elf2 = priorityQueue.poll()
        val elf3 = priorityQueue.poll()
        return elf1 + elf2 + elf3
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 18)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
