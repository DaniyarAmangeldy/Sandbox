package com.example.sandbox


/*
     Имена

     1) class ColoredBtn -> ColoredButton..  class AddnlCard -> class AdditionalCard -- Избегайте сокращений, аббревевеатур и т д
     2) Boolean -> isColored (true, false) <- Старайтесь называть переменные задающим вопросом
     3) Magic number = Плохой запах кода. val calculatedResult = myMoney * 421 (421 - Magic number)
     Constants -> fix Magic Number =  val calculatedResult = myMoney * USD_TO_KZT_EXCHANGE_RATE
     const val
     Map.put("EXTRA_RESULT", Value)
     4) Имена функции всегда должны быть глагольными -> addChtoToKChemuTo, remove, update, jump, seat.
     fun isButtonColored()
     fun getIntentFor(): Intent  || fun createIntentFor() || buildIntentFor(): Intent
     5) Pure functions
     5.1) Всегда имеет input, output.  F(x) = y
     5.2) No Side effects:
     fun isButtonColored(view: View): Boolean {
         if (view.background.color == Gray) {
             view.background.color = White     <-- Side Effect
         }
         return view.button.hasColor()
     }
     5.3) Функции должны делать ровно то, о чем заявляют, как именованы и т д :D
     5.4) Старайтесь не увеличивать функции - делить на более мелкие части
     LifeHack: Смотришь на функцию и задаешься вопросом: Могу ли я разбить функцию на 2 и более
          case ДА -> разбить функцию
          case НЕТ -> функция готова
     if (view.background.color == Gray) {
             changeBackgroundColor(White)
         }
    isButtonColored()

     fun changeBackgroundColor(color: Color)

     fun isButtonColored(view: View): Boolean {
         return view.button.hasColor()
     }
     5.5) Желательная длина строк в 1 функции ~ 20 строк
     5.6) Количество параметров в методе должно быть не больше 3
     5.7) Избегайте Флажки как параметр

    fun processPayment(isVipClient: Boolean?, isClientInBlackList: Boolean) {
        if (isVipClient != null && isVipClient == true) {
            ....
            if (isClientInBlackList) {
                ...
            }
             ....
        } else {

            ....
        }
    }

    5.8) Ранний return

    fun processPayment(isVipClient: Boolean?, isClientInBlackList: Boolean) {
        if (isVipClient == null) {
            return
        }
        if (isVipClient == false) {
            ....
            return
        }
        ...
    }

     6) Классы -> Имена Существительные.
     6.1) Избегайте generic названии -> ProductManager, ProductService, ProductHelper <- признак God Object
     6.2) Классы должны иметь только 1 зону ответственности  -> ViewHolder - Держать вьюшку
     7) Старайтесь избегать излишних комментариев
     7.1) Пишите TODO там где можно
     7.2) JavaDoc для описания API
     8) Старайтесь держать методы, классы на одном абстрактном уровне

     fun processPayment(payment: Payment): Result {
         payment.inputFields.forEach { field ->
             when (field) {
                 is DatePicker -> if (date > today) return Result.ValidationError
                 ...
                 else -> if (field.isEmpty) return Result.ValidationError
             }
         }
         val result = api.processPayment(payment)
         return result
     }
     ------------------------------------------
     val validator: InputFieldValidator
     fun processPayment(payment: Payment): Result {
         if (!validator.validate(payment.inputFields)) {
             return Result.ValidationError
         }
         val result = api.processPayment(payment)
         return result
     }
 */

const val MY_CONST = 1 // CleanCode.MY_CONST

class CleanCode {

    var isButtonColored: Boolean

    companion object {
        const val MY_CONST = 1 // CleanCode.MY_CONST
    }

    init {
        isButtonColored = true
        if (isButtonColored) {

        }
    }
}