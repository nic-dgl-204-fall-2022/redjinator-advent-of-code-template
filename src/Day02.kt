fun main() {

    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    var totalPaper : Double = 0.0

    fun getSurfaceArea(l: Double, w: Double, h: Double): Double {
        val surfaceArea = 2*(l*w) + 2*(w*h) + 2*(h*l)
        val smallestSide = minOf(l*w, w*h, h*l)
        return (surfaceArea + smallestSide)
    }

    val inputFile = readInput("inputdata").map { it.split('x') }

    for (i in inputFile.indices) {
        val l = inputFile[i][0].toDouble()
        val w = inputFile[i][1].toDouble()
        val h = inputFile[i][2].toDouble()
        totalPaper += getSurfaceArea(l, w, h)
    }

    println("Total Paper Req: $totalPaper")
}
