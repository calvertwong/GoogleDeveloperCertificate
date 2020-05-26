package com.calvert.customview.lightbulb

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.View
import android.view.accessibility.AccessibilityNodeInfo
import androidx.core.view.AccessibilityDelegateCompat
import androidx.core.view.ViewCompat
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat
import com.calvert.customview.R

class LightBulb @JvmOverloads constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int = 0) :
    View(context, attributeSet, defStyleAttr) {

    private var dimness = Dimness.OFF
    private var dimColor: Int = 0
    private var brightColor: Int = 0
    private lateinit var ovalTopStroke: RectF
    private lateinit var ovalTopFill: RectF

    private val paintBulbMetalFill: Paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = Color.LTGRAY
    }

    private val paintBulbStroke: Paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        color = Color.DKGRAY
        strokeWidth = 10F
    }

    private val paintBulbFill: Paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        strokeWidth = 10F
    }

    private val paintText: Paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        textAlign = Paint.Align.CENTER
        textSize = 60.0f
        color = Color.BLUE
        typeface = Typeface.DEFAULT_BOLD
    }

    init {
        isClickable = true

        val typedArray: TypedArray = context.obtainStyledAttributes(attributeSet, R.styleable.LightBulb)
        dimColor = typedArray.getColor(R.styleable.LightBulb_dimColor, 0)
        brightColor = typedArray.getColor(R.styleable.LightBulb_brightColor, 0)
        typedArray.recycle()

        updateContentDescription()

        ViewCompat.setAccessibilityDelegate(this, object : AccessibilityDelegateCompat() {
            override fun onInitializeAccessibilityNodeInfo(host: View?, info: AccessibilityNodeInfoCompat?) {
                super.onInitializeAccessibilityNodeInfo(host, info)
                val customClick = AccessibilityNodeInfoCompat.AccessibilityActionCompat(
                    AccessibilityNodeInfo.ACTION_CLICK,

                    context.getString(if (dimness != Dimness.BRIGHT) R.string.change else R.string.reset)
                )
                // execute accessibility action and for this case it is a click action
                info?.addAction(customClick)
            }
        })
    }

    override fun performClick(): Boolean {
        if (super.performClick()) return true

        dimness = dimness.next()
        updateContentDescription()
        invalidate()
        return true
    }

    override fun onSizeChanged(width: Int, height: Int, oldWidth: Int, oldHeight: Int) {
        super.onSizeChanged(width, height, oldWidth, oldHeight)
        ovalTopStroke = RectF(
            (width / 5.5).toFloat(), (height - height * 0.70).toFloat(), (width - width / 5.5).toFloat(), (height - height * 0.4).toFloat()
        )
        ovalTopFill = RectF(
            (width / 5.3).toFloat(), (height - height * 0.695).toFloat(), (width - width / 5.3).toFloat(), (height - height * 0.395).toFloat()
        )
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paintBulbFill.color = when (dimness) {
            Dimness.OFF -> Color.WHITE
            Dimness.DIM -> dimColor
            Dimness.BRIGHT -> brightColor
        }

        // bulb metal
        // bottom rect
        canvas?.drawRect(
            (width / 3.5).toFloat(),
            (height - height * 0.2).toFloat(),
            (width - width / 3.5).toFloat(),
            (height - height * 0.25).toFloat(),
            paintBulbStroke
        )
        canvas?.drawRect(
            (width / 3.5).toFloat(),
            (height - height * 0.2).toFloat(),
            (width - width / 3.5).toFloat(),
            (height - height * 0.25).toFloat(),
            paintBulbMetalFill
        )
        // top rect
        canvas?.drawRect(
            (width / 3.5).toFloat(),
            (height - height * 0.254).toFloat(),
            (width - width / 3.5).toFloat(),
            (height - height * 0.306).toFloat(),
            paintBulbStroke
        )
        canvas?.drawRect(
            (width / 3.5).toFloat(),
            (height - height * 0.254).toFloat(),
            (width - width / 3.5).toFloat(),
            (height - height * 0.306).toFloat(),
            paintBulbMetalFill
        )

        // bulb glass lines
        // left straight line
        canvas?.drawLine(
            (width / 3.5).toFloat(),
            (height - height * 0.4).toFloat(),
            (width / 3.5).toFloat(),
            (height - height * 0.306).toFloat(),
            paintBulbStroke
        )
        // right straight line
        canvas?.drawLine(
            (width - width / 3.5).toFloat(),
            (height - height * 0.4).toFloat(),
            (width - width / 3.5).toFloat(),
            (height - height * 0.306).toFloat(),
            paintBulbStroke
        )
        // left angled line
        canvas?.drawLine(
            (width / 5.5).toFloat(),
            (height - height * 0.55).toFloat(),
            (width / 3.5).toFloat(),
            (height - height * 0.4).toFloat(),
            paintBulbStroke
        )
        // right angled line
        canvas?.drawLine(
            (width - width / 5.5).toFloat(),
            (height - height * 0.55).toFloat(),
            (width - width / 3.5).toFloat(),
            (height - height * 0.4).toFloat(),
            paintBulbStroke
        )
        // bulb glass arc
        canvas?.drawArc(ovalTopStroke, 180F, 180F, false, paintBulbStroke)
        canvas?.drawArc(ovalTopFill, 180F, 180F, false, paintBulbFill)

        canvas?.drawText(dimness.name, (width / 2).toFloat(), (height - height * 0.47).toFloat(), paintText)
    }

    private fun updateContentDescription() {
        contentDescription = resources.getString(dimness.label)
    }

    // return the dimness value
    fun getDimLevel(): String {
        return dimness.name
    }

}

enum class Dimness(val label: Int) {
    OFF(R.string.lights_off),
    DIM(R.string.dim),
    BRIGHT(R.string.bright);

    fun next() = when (this) {
        OFF -> DIM
        DIM -> BRIGHT
        BRIGHT -> OFF
    }
}