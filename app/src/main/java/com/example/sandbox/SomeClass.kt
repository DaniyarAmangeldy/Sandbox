package com.example.sandbox

// POJO - Plain Old Java Object
data class Card(
    val number: String,
    val id: String,
    val paymentSystem: SampleSealedClass
)

enum class PaymentSystem {
    VISA(),
    MASTERCARD(),
    MAESTRO()
}

sealed class SampleSealedClass(val value: String) {
    data class VISA(val id: String): SampleSealedClass("VISA")
    data class MASTERCARD(val title: String): SampleSealedClass("MASTERCARD")
    object MAESTRO: SampleSealedClass("MAESTRO")
}

//fun isVisa(card: Card): Boolean {
//    return when (card.paymentSystem) {
//        is SampleSealedClass.VISA -> card.paymentSystem.id
//        is SampleSealedClass.MASTERCARD -> card.paymentSystem.title
//        SampleSealedClass.MAESTRO ->
//    }
//}