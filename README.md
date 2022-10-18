# Redjinator Advent of code

link: [Day 2 - Advent of Code 2015](https://adventofcode.com/2015/day/2)

## Overview of problem 1
For this problem we need to calculate the square feet of wrapping paper we're going to need to finish wrapping the remaining presents <br>
by calculating the surface area of each present using a locally stored measurement data in a file called `input.txt` containing a list of strings representing length, width, and height values separated by `"x"`
_See example (below)_

Sample of `input.txt`
```
29x13x26
11x11x14
27x2x5
6x10x13
15x19x10
```
### Obstacles
* Get measurements from file, and convert to Int for use.
* Calculate the surface area of each present.
* Calculate the extra slack for each present.
* Repeat for remaining presents

## First solution


### part1() function
The _part1( )_ function is the intended vehicle for our solution which will return an `Int` variable representing the `totalPaper` required.
The list of measurements in the file `input.txt` is obtained using `readInput()`  found in `Utils.kt` and passed as an argument to `part1()`.


```
    // Part 1
    fun part1(input: List<String>): Int {

        // Create a list of Int's from the list of Strings
        val measurements = input.map { it.split('x') }.map { it.map { it.toInt() }}

        // container for solution
        var totalPaper   = 0

        // gets paper and slack required for each box and adds it to total
        for (i in measurements.indices) {
            val (length, width, height) = Triple(measurements[i][0], measurements[i][1], measurements[i][2])
            val paperRequired = getSurfaceArea(length, width, height)
            val slackRequired = getExtraSlack(length, width, height)

            totalPaper   += (paperRequired + slackRequired)
        }
        return totalPaper
    }
```

## Obstacle 1
 Chaining together uses of `.map{ }` allowed us to create a new list with `Int` values _(seen below)_. The use of `it` parameter and chaining format are also idomatic of Kotlin.
 * The first use deliniates the measurements using `x` resulting in a single string ex:`"10x12x3"` changing to a list containing 3 string elements `["10", "12", "3"]`.
 * The second use is used on the resulting list to target it's elements
 * The third use is used on the elements to target it's values and cast them to Int using `.toInt()`
```
// Create a list of Int's from the list of Strings
val measurements = input
    .map { it.split('x') }
    .map { it.map { it.toInt() }}
```

## Obstacles 2 && 3
Created 2 functions `getSurfaceArea()` and `getExtraSlack()` to calculate the surface area and extra slack of each present. They also use the shorthand which is idiomatic of Kotlin.
```
fun getSurfaceArea(l: Int, w: Int, h: Int): Int  = 2 * (l * w) + 2 * (w * h) + 2 * (h * l)

fun getExtraSlack(l: Int, w: Int, h: Int): Int =  minOf(l * w, w * h, h * l)
```

## Obstacle 4
Used a `for` loop to iterate through the list of measurements 1 present at a time and use functions `getSurFaceArea()` and `getExtraSlack()` to calculate the numbers and add them to the total each loop.

Note: Using the Triple seemed like an easy way to add some readability to the code in a more concise way than assigning each dimension individually.
```
        // gets paper and slack required for each box and adds it to total
        for (i in measurements.indices) {
            val (length, width, height) = Triple(measurements[i][0], measurements[i][1], measurements[i][2])
            val paperRequired = getSurfaceArea(length, width, height)
            val slackRequired = getExtraSlack(length, width, height)

            totalPaper   += (paperRequired + slackRequired)
        }
```

I could have removed a line by using the measurements this way _(below)_ but I think it's less readable.:
```
        // gets paper and slack required for each box and adds it to total
        for (i in measurements.indices) {
            val paperRequired = getSurfaceArea(measurements[i][0], measurements[i][1], measurements[i][2])
            val slackRequired = getExtraSlack(measurements[i][0], measurements[i][1], measurements[i][2])

            totalPaper   += (paperRequired + slackRequired)
        }
```



---

## Overview of problem 2
For this problem we need to calculate the amount of ribbon we're going to need <br>
The ribbon required is the shortest distance around the sides or the smallest perimeter of any single face.



### Steps
* Obtain measurements (length, width, and height) from file and cast values to Int.
* Calculate the smallest perimeter of any face.
* Calculate the volume cubed.

## Second solution













```kotlin
for (value in input) {
    println("We love the smell of bread in Paris!")
}
```
---
# Reflection
Take some time to reflect on your process for each Advent of Code assignment. Please write your reflection in the repository README.md file. You may take any approach you like for your reflection, but key questions to consider are:

How long did you take to find a complete solution? <br>
What documentation and resources did you use to identify your solution? <br>
Did you use a good commit process (i.e. commit stable codon a regular basis?) <br>
Did you discuss your potential solution with any of your peers? <br>
What process did you take to identify your idiomatic code choices? <br>
What did you learn about the language, or about idioms or refactoring in the process? <br>
How did you find the writing process and the argumentation in support of your refactored code? <br>
Your reflection should be at least two well-formed paragraphs.


---
### Welcome to the Advent of Code[^aoc] Kotlin project created by [redjinator][github] using the [Advent of Code Kotlin Template][template] delivered by JetBrains.

In this repository, redjinator is about to provide solutions for the puzzles using [Kotlin][kotlin] language.

If you're stuck with Kotlin-specific questions or anything related to this template, check out the following resources:

- [Kotlin docs][docs]
- [Kotlin Slack][slack]
- Template [issue tracker][issues]


[^aoc]:
    [Advent of Code][aoc] – An annual event of Christmas-oriented programming challenges started December 2015.
    Every year since then, beginning on the first day of December, a programming puzzle is published every day for twenty-five days.
    You can solve the puzzle and provide an answer using the language of your choice.

[aoc]: https://adventofcode.com
[docs]: https://kotlinlang.org/docs/home.html
[github]: https://github.com/redjinator
[issues]: https://github.com/kotlin-hands-on/advent-of-code-kotlin-template/issues
[kotlin]: https://kotlinlang.org
[slack]: https://surveys.jetbrains.com/s3/kotlin-slack-sign-up
[template]: https://github.com/kotlin-hands-on/advent-of-code-kotlin-template
