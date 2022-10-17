fun main() {

    fun remove(arr: IntArray, index: Int): IntArray {
        if (index < 0 || index >= arr.size) {
            return arr
        }

        val result = arr.toMutableList()
        result.removeAt(index)
        return result.toIntArray()
    }

    fun getSurfaceArea(l: Int, w: Int, h: Int): Int {
        val surfaceArea = 2 * (l * w) + 2 * (w * h) + 2 * (h * l)
        return (surfaceArea + minOf(l * w, w * h, h * l))
    }

    fun getSmallestPerimeter(l: Int, w: Int, h: Int): Int {
        val maxUnit = maxOf(l, w, h)
        val arr = intArrayOf(l, w, h)
        val index = arr.indexOf(maxUnit)
        val arr2 = remove(arr, index)
        return arr2[0] + arr2[0] + arr2[1] + arr2[1]
    }

    fun getVolumeCubed(l: Int, w: Int, h: Int): Int {
        return l*w*h
    }



    fun part1(input: List<String>): Int {
        val inputSplit = input.map { it.split('x') }
        var totalPaper: Int = 0

        for (i in inputSplit.indices) {
            totalPaper += getSurfaceArea(inputSplit[i][0].toInt(), inputSplit[i][1].toInt(), inputSplit[i][2].toInt())
        }
        return totalPaper
    }

    fun part2(input: List<String>): Int {
        val inputSplit = input.map { it.split('x')}

        var peremiter: Int = 0
        var volume: Int = 0

        for (i in inputSplit.indices) {
            peremiter += getSmallestPerimeter(inputSplit[i][0].toInt(), inputSplit[i][1].toInt(), inputSplit[i][2].toInt())
            volume    += getVolumeCubed(inputSplit[i][0].toInt(), inputSplit[i][1].toInt(), inputSplit[i][2].toInt())
        }
        return peremiter + volume
    }

    val input = readInput("inputdata")
    println("Part 1: " + part1(input))
    println("Part 2: " + part2(input))
}