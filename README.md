# Redjinator Advent of code

link: [Day 2 - Advent of Code 2015](https://adventofcode.com/2015/day/2)

## Overview of problem 1
For this problem we need to calculate the square feet of wrapping paper we're going to need to finish wrapping the remaining presents <br>
by calculating the surface area of each present using a locally stored measurement data in a file called `input.txt` containing a list of strings representing length, width, and height values separated by `"x"`
_See example (below)_

Sample of `input.txt`
```kotlin
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


```kotlin
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
```kotlin
// Create a list of Int's from the list of Strings
val measurements = input
    .map { it.split('x') }
    .map { it.map { it.toInt() }}
```

## Obstacles 2 && 3
Created 2 functions `getSurfaceArea()` and `getExtraSlack()` to calculate the surface area and extra slack of each present. They also use the shorthand which is idiomatic of Kotlin.
```kotlin
fun getSurfaceArea(l: Int, w: Int, h: Int): Int  = 2 * (l * w) + 2 * (w * h) + 2 * (h * l)

fun getExtraSlack(l: Int, w: Int, h: Int): Int =  minOf(l * w, w * h, h * l)
```

## Obstacle 4
Used a `for` loop to iterate through the list of measurements 1 present at a time and use functions `getSurFaceArea()` and `getExtraSlack()` to calculate the numbers and add them to the total each loop.

Note: Using the Triple seemed like an easy way to add some readability to the code in a more concise way than assigning each dimension individually.
```kotlin
        // gets paper and slack required for each box and adds it to total
        for (i in measurements.indices) {
            val (length, width, height) = Triple(measurements[i][0], measurements[i][1], measurements[i][2])
            val paperRequired = getSurfaceArea(length, width, height)
            val slackRequired = getExtraSlack(length, width, height)

            totalPaper   += (paperRequired + slackRequired)
        }
```

I could have removed a line by using the measurements this way _(below)_ but I think it's less readable.:
```kotlin
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
### part2() function
The _part2( )_ function is the intended vehicle for our solution which will be returned as an `Int` variable represented by `totalRibbon` which is the sum of the smallest perimeter and cubic feet of volume
```kotlin
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
```


## Obstacle 1
Handled the exact same way as in problem 1

## Obstacle 2
To get the perimeter of the smallest face I needed the 2 smallest values out of (lxwxh). So I determined the maxValue of (l,w,h), put them into an array and targeted the largest value using it's index and removing it. This way I only needed to manipulate a single value instead of trying to target the 2 smallest values.
```kotlin
    fun getSmallestPerimeter(l: Int, w: Int, h: Int): Int {
        val maxValue              = maxOf(l, w, h)
        val measurementSet        = intArrayOf(l, w, h)
        val indexOfMax            = measurementSet.indexOf(maxValue)
        val measurementPair       = remove(measurementSet, indexOfMax)

        return measurementPair[0] + measurementPair[0] + measurementPair[1] + measurementPair[1]
    }
```

This is the remove function I used to remove the largest value from my IntArray in the `getSmallestPerimeter()` function. I believe I found this on the Kotlin site in the examples somewhere. I can't find the location at present.
```kotlin
    fun remove(arr: IntArray, index: Int): IntArray {
        if (index < 0 || index >= arr.size) {
            return arr
        }

        val result = arr.toMutableList()
        result.removeAt(index)
        return result.toIntArray()
    }
```
## Obstacle 3
To get the cubic feet of volume of each present I wrote the following single line function in kotlin shorthand
```kotlin
fun getVolumeCubed(l: Int, w: Int, h: Int): Int { return l*w*h }
```


---
# Reflection
You may take any approach you like for your reflection, but key questions to consider are:

How long did you take to find a complete solution? <br>
It took me about 2 or 3 hours to get the solutions and about double that amount of time refactoring and revising this document. I primarily used [kotlinlang.org](https://kotlinlang.org/docs/home.html)

Did you use a good commit process (i.e. commit stable codon a regular basis?) <br>
I tried to enter my commits better but there is much room for improvement. I lost track a few times and ended up rolling multiple changes into one. I almost feel like I  need to plan my commit before working on it so I have a goal.

Did you discuss your potential solution with any of your peers? <br>
Unfortunately most of this project was done after midnight and on breaks at work so I did not get a chance to touch base with my classmates.


What process did you take to identify your idiomatic code choices? <br>
I looked at each section of my code and looked for relavant examples at [Kotlinlang.org](https://kotlinlang.org/) in the [Idioms](https://kotlinlang.org/docs/idioms.html) and [Coding Conventions](https://kotlinlang.org/docs/coding-conventions.html) sections to determine if I needed to make any idiomatic changes.



How did you find the writing process and the argumentation in support of your refactored code? <br> I'm a little worried I didn't go in depth enough as I only really identified areas where I made mistakes and ignored any natually followed idioms or conventions but I need to move forward to other work.










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
