package ru.netology

fun main() {
    val seconds = 3600 * 10 + 1
    println(agoToText(seconds))
}

fun agoToText(seconds: Int): String {
    return when (seconds) {
        in (0..60) -> "только что"
        in (61..60 * 60) -> {
            val minute = (seconds / 60).toInt()
            "$minute минут${minuteEnding(minute)} назад"
        }
        in (60 * 60 + 1..secondsInDay()) -> {
            val hour = (seconds / 3600).toInt()
            "$hour час${hourEnding(hour)} назад"
        }
        in (secondsInDay() + 1..secondsInDay() * 2) -> "сегодня"
        in (secondsInDay() * 2 + 1..secondsInDay() * 3) -> "вчера"
        else -> "давно"
    }
}

fun secondsInDay() = 60 * 60 * 24

fun minuteEnding(minute: Int): String {
    return when {
        (minute - 1) % 10 == 0 || minute == 1 -> "у"
        ((minute - 2) % 10 == 0 || minute == 2) ||
                ((minute - 3) % 10 == 0 || minute == 3) ||
                ((minute - 4) % 10 == 0 || minute == 4) -> "ы"
        else -> ""
    }
}

fun hourEnding(hour: Int): String {
    return when (hour) {
        1, 21 -> ""
        2, 3, 4, 22, 23, 24 -> "а"
        else -> "ов"
    }
}
