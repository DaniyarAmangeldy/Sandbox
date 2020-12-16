package com.example.sandbox

import java.util.*

operator fun Number.plus(other: Number): Number {
    return other
}

operator fun Number.minus(other: Number): Number {
    return other
}


operator fun Date.compareTo(other: Date): Int {
    return (this.time - other.time).toInt()
}

operator fun MyStringBuilder.invoke() {
    mapOf(
        "key" with "value"
    )
}

infix fun <T> T.with(other: T): Pair<T, T> {
    return Pair(this, other)
}

inline fun inlinedFunction() {
    print("Hello World!")
}


