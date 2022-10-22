import java.lang.Integer.min

fun main() {

    fun getSurfaceArea(l: Int, w: Int, h: Int): Int  = 2 * (l * w) + 2 * (w * h) + 2 * (h * l)

    fun getExtraSlack(l: Int, w: Int, h: Int): Int =  minOf(l * w, w * h, h * l)


    // Part 1
    fun part1(input: List<String>): Int {
        var totalPaper = 0

        for (dimensions in input) {
            val (length, width, height) = dimensions.split("x").map { it.toInt() }
            val paperRequired = getSurfaceArea(length, width, height)
            val slackRequired = getExtraSlack(length, width, height)

            totalPaper   += (paperRequired + slackRequired)
        }
        return totalPaper
    }

    fun getSmallestPerimeter(l: Int, w: Int, h: Int): Int = 2 * minOf(l + w, w + h, l + h)

    fun getVolumeCubed(l: Int, w: Int, h: Int): Int { return l*w*h }

    fun part2(input: List<String>): Int {

        val measurements = input
            .map { it.split('x') }
            .map { it.map { it.toInt() }}

        var totalRibbon: Int = 0

        for (i in measurements.indices) {
            val perimeter    = getSmallestPerimeter(measurements[i][0], measurements[i][1], measurements[i][2])
            val volume       = getVolumeCubed(measurements[i][0], measurements[i][1], measurements[i][2])
            totalRibbon     += perimeter + volume
        }

        return totalRibbon
    }

    val input = readInput("input")
    println("Part 1 Paper required: "  + part1(input))
    println("Part 2 Ribbon required: " + part2(input))
}