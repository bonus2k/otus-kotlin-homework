package ru.otus.kotlin.compose1

import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType
import kotlinx.cli.default

fun main(args: Array<String>) {
    val parser = ArgParser("compos1")

    val name by parser.option(
        type = ArgType.String,
        shortName = "n",
        description = "Name"
    ).default("world")

    parser.parse(args)
    println("Hello, $name!")
}