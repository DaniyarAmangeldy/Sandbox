package com.example.sandbox

import android.content.Context
import android.content.DialogInterface
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog

class HomeWork {

    fun Context.showDialog(builder: MyAlertDialogBuilder.() -> Unit) {
        MyAlertDialogBuilder(this).apply { builder.invoke(this) }.builder.show()

    }

    class MyAlertDialogBuilder(context: Context) {
        val builder = AlertDialog.Builder(context)

        var description: String = ""
            set(value) {
                field = value
                builder.setMessage(value)
            }

        fun title(@StringRes id: Int) {
            builder.setTitle(id)
        }

        fun positiveButton(@StringRes id: Int): ButtonBuilder {
            return ButtonBuilder(id)
        }

        infix fun ButtonBuilder.onClick(action: (DialogInterface) -> Unit) {
            builder.setPositiveButton(id) { dialogInterface, _ -> action.invoke(dialogInterface) }
        }


        data class ButtonBuilder(val id: Int)
    }
}