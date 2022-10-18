# Redjinator Advent of code

link: [Day 2 - Advent of Code 2015](https://adventofcode.com/2015/day/2)

## Overview of problem 1
For this problem we need to calculate the square feet of wrapping paper we're going to need to finish wrapping the remaining presents <br>
by calculating the surface area of each present using measurement data stored locally in a file called `input.txt` as a list of strings <br>

Measurements are a single string containing length, width, and height separated by `"x"`
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
* Get measurements (length, width, and height) from file and cast values to Int
* Calculate the surface area of each present.
* Calculate the extra slack for each present.
* Repeat for remaining presents

## First solution


### function _part1 ( )_
The _part1()_ function is the primary vehicle for our solution which we pass a list of measurements from the file `input.txt` using the `readInput()` function found in `Utils.kt`.


```
fun part1(input: List<String>): Int {
    val inputSplit = input.map { it.split('x') }.map { it.map { it.toInt() }}
    var totalPaper   = 0

    for (i in inputSplit.indices) {
        totalPaper   += getSurfaceArea(inputSplit[i][0], inputSplit[i][1], inputSplit[i][2])
    }
    return totalPaper
}
```

## Obstacle #1
 Chaining together uses of `.map{ }` allowed us to create a new list with values converted to `Int` _(seen below)_.
```
val inputSplit = input.map { it.split('x') }.map { it.map { it.toInt() }}
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
