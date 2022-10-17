fun main() {

    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    var totalPaper : Double = 0.0

    fun getSmallestSide(l: Double, w: Double, h: Double): Double {
        return if (l*w <= w*h && l*w <= h*l) {
            l*w
        } else if (w*h <= l*w && w*h <= h*l) {
            w*h
        } else {
            h*l
        }
    }

    fun getSurfaceArea(l: Double, w: Double, h: Double): Double {
        val surfaceArea = 2*(l*w) + 2*(w*h) + 2*(h*l)
        val extra = getSmallestSide(l, w, h)
        return (surfaceArea + extra)
    }

    val inputSplit = readInput("inputdata").map { it.split('x') }

    for (i in inputSplit.indices) {
        val l = inputSplit[i][0].toDouble()
        val w = inputSplit[i][1].toDouble()
        val h = inputSplit[i][2].toDouble()
        totalPaper += getSurfaceArea(l, w, h)
    }

    println("Total Paper Req: $totalPaper")
}
