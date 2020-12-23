package com.example.sandbox

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View

class MyCustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
): View(context) {

    init {
        invalidate()        // Сбросить кэш вьюшки
        requestLayout()     // Запрос на пересмотр положения вьюшки в полотне (layout)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }
}