package ru.netology

import kotlin.math.roundToInt

fun main() {
    val cardType = "МИР"
    val monthAmount = 30_000
    val moneyTransfer = 5_000
    val commissionResult = commission(cardType, monthAmount, moneyTransfer)
    if (commissionResult != null) println("Your commission is $commissionResult")
}

fun commission(cardType: String = "VK Pay", monthAmount: Int = 0, moneyTransfer: Int): Int? {
    val commission: Int?
    val limitMax = 600_000
    val limitMaxVKPay = 40_000
    when (cardType) {
        "VK Pay" -> {
            commission = if (monthAmount + moneyTransfer > limitMaxVKPay) {
                println("Limit was exceeded")
                null
            } else 0
        }
        "Mastercard", "Maestro" -> {
            commission = if (monthAmount + moneyTransfer > limitMax) (moneyTransfer * 0.06 + 20).roundToInt() else 0
        }
        "Visa", "МИР" -> {
            commission = if (monthAmount + moneyTransfer <= limitMax) {
                if (moneyTransfer * 0.075 > 35) (moneyTransfer * 0.075).roundToInt() else 35
            } else {
                println("Limit was exceeded")
                null
            }
        }
        else -> {
            println("$cardType doesn`t exist")
            commission = null
        }
    }
    return commission
}