fun main() {

    // Part 1 - remove
    fun remove(arr: IntArray, index: Int): IntArray {
        if (index < 0 || index >= arr.size) {
            return arr
        }

        val result = arr.toMutableList()
        result.removeAt(index)
        return result.toIntArray()
    }

    // Part 1 - getSurfaceArea
    fun getSurfaceArea(l: Int, w: Int, h: Int): Int {
        val surfaceArea  = 2 * (l * w) + 2 * (w * h) + 2 * (h * l)
        val extraSlack = minOf(l * w, w * h, h * l)
        return (surfaceArea + extraSlack)
    }

    // Part 1
    fun part1(input: List<String>): Int {
        val inputSplit = input.map { it.split('x') }.map { it.map { it.toInt() }}
        var totalPaper   = 0

        for (i in inputSplit.indices) {
            totalPaper   += getSurfaceArea(inputSplit[i][0], inputSplit[i][1], inputSplit[i][2])
        }
        return totalPaper
    }

    // Part 2 - getSmallestPerimeter
    fun getSmallestPerimeter(l: Int, w: Int, h: Int): Int {
        val maxValue = maxOf(l, w, h)
        val measurementSet     = intArrayOf(l, w, h)

        val indexOfMax = measurementSet.indexOf(maxValue)
        val measurementPair       = remove(measurementSet, indexOfMax)
        return measurementPair[0] + measurementPair[0] + measurementPair[1] + measurementPair[1]
    }

    // Part 2 - getVolumeCubed
    fun getVolumeCubed(l: Int, w: Int, h: Int): Int { return l*w*h }

    // Part 2
    fun part2(input: List<String>): Int {

        val inputSplit = input.map { it.split('x') }.map { it.map { it.toInt() }}
        var perimeter    = 0
        var volume       = 0

        for (i in inputSplit.indices) {
            perimeter    += getSmallestPerimeter(inputSplit[i][0].toInt(), inputSplit[i][1].toInt(), inputSplit[i][2].toInt())
            volume       += getVolumeCubed(inputSplit[i][0].toInt(), inputSplit[i][1].toInt(), inputSplit[i][2].toInt())
        }
        return perimeter + volume
    }

    val input = readInput("input")
    println("Part 1 Paper required: "  + part1(input))
    println("Part 2 Ribbon required: " + part2(input))
}