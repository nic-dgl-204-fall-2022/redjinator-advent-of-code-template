fun main() {
    
    fun remove(arr: IntArray, index: Int): IntArray {
        if (index < 0 || index >= arr.size) {
            return arr
        }

        val result = arr.toMutableList()
        result.removeAt(index)
        return result.toIntArray()
    }


    fun getSurfaceArea(l: Int, w: Int, h: Int): Int  = 2 * (l * w) + 2 * (w * h) + 2 * (h * l)

    fun getExtraSlack(l: Int, w: Int, h: Int): Int =  minOf(l * w, w * h, h * l)


    // Part 1
    fun part1(input: List<String>): Int {

        val measurements = input
            .map { it.split('x') }
            .map { it.map { it.toInt() }}

        var totalPaper   = 0

        for (i in measurements.indices) {
            val (length, width, height) = Triple(measurements[i][0], measurements[i][1], measurements[i][2])
            val paperRequired = getSurfaceArea(length, width, height)
            val slackRequired = getExtraSlack(length, width, height)

            totalPaper   += (paperRequired + slackRequired)
        }
        return totalPaper
    }

    fun getSmallestPerimeter(l: Int, w: Int, h: Int): Int {
        val measurementSet        = intArrayOf(l, w, h)
        val indexOfMax            = measurementSet.indexOf(maxOf(l, w, h))
        val measurementPair       = remove(measurementSet, indexOfMax)

        return measurementPair[0] + measurementPair[0] + measurementPair[1] + measurementPair[1]
    }

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