package com.calvert.customview.speedknob.util

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.View
import android.view.accessibility.AccessibilityNodeInfo
import androidx.core.view.AccessibilityDelegateCompat
import androidx.core.view.ViewCompat
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat
import com.calvert.customview.R
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin

/*
 * Reference: https://codelabs.developers.google.com/codelabs/advanced-andoid-kotlin-training-custom-views/#0
 */
class SpeedKnob @JvmOverloads constructor(context: Context, attributeSet: AttributeSet? = null, defStyleAttr: Int = 0) :
    View(context, attributeSet, defStyleAttr) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        textAlign = Paint.Align.CENTER
        textSize = 55.0f
        typeface = Typeface.create("", Typeface.BOLD)
    }

    // this provides style to texts
    private val paintText = Paint(Paint.UNDERLINE_TEXT_FLAG).apply {
        style = Paint.Style.FILL
        textAlign = Paint.Align.CENTER
        textSize = 50.0f
        color = Color.BLUE
        typeface = Typeface.create("", Typeface.BOLD)
    }

    private var radius = 0.0f
    private var fanSpeed = FanSpeed.OFF
    private val pointPosition: PointF = PointF(0.0f, 0.0f)

    private var fanSpeedLowColor: Int = 0
    private var fanSpeedMediumColor: Int = 0
    private var fanSpeedMaxColor: Int = 0

    init {
        isClickable = true

        // this obtains the color from the xml files
        val typedArray: TypedArray = context.obtainStyledAttributes(attributeSet, R.styleable.SpeedKnob)
        fanSpeedLowColor = typedArray.getColor(R.styleable.SpeedKnob_fanColor1, 0)
        fanSpeedMediumColor = typedArray.getColor(R.styleable.SpeedKnob_fanColor2, 0)
        fanSpeedMaxColor = typedArray.getColor(R.styleable.SpeedKnob_fanColor3, 0)
        typedArray.recycle()

        // for accessibility
        updateContentDescription()

        // accessibilitDelegate enables us to customize the accessibility-related features.
        // AccessibilityDelegateCompat enables backward compatibility
        ViewCompat.setAccessibilityDelegate(this, object : AccessibilityDelegateCompat() {
            override fun onInitializeAccessibilityNodeInfo(host: View?, info: AccessibilityNodeInfoCompat?) {
                super.onInitializeAccessibilityNodeInfo(host, info)
                val customClick = AccessibilityNodeInfoCompat.AccessibilityActionCompat(
                    AccessibilityNodeInfo.ACTION_CLICK,

                    context.getString(if (fanSpeed != FanSpeed.HIGH) R.string.change else R.string.reset)
                )
                // execute accessibility action and for this case it is a click action
                info?.addAction(customClick)
            }
        })
    }

    override fun performClick(): Boolean {
        if (super.performClick()) return true

        fanSpeed = fanSpeed.next()
        updateContentDescription()

//      Use invalidate() to force a draw or redraw of the view.
        invalidate()
        return true
    }

    // calculate the view's size on the first appearance and when the view's size changes (orientation change)
    override fun onSizeChanged(width: Int, height: Int, oldWidth: Int, oldHeight: Int) {
        radius = (min(width, height) / 2.0 * 0.8).toFloat()
    }

    // to draw a custom view using a Canvas object and styled by a Paint object
    // for performance reasons, do as little work as possible
    // draw text using drawText()
    // drawRect(), drawOval(), drawArc()
    // drawBitmap()
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.color = when (fanSpeed) {
            FanSpeed.OFF -> Color.GRAY
            FanSpeed.LOW -> fanSpeedLowColor
            FanSpeed.MEDIUM -> fanSpeedMediumColor
            FanSpeed.HIGH -> fanSpeedMaxColor
        }

        // Outer circle
        canvas?.drawCircle((width / 2).toFloat(), (height / 2).toFloat(), radius, paint)

        // Text inside the circle
        canvas?.drawText(fanSpeed.ordinal.toString(), (width / 2).toFloat(), (height / 2).toFloat(), paintText)

        val markerRadius = radius + RADIUS_OFFSET_INDICATOR
        pointPosition.computeXYForSpeed(fanSpeed, markerRadius)
        paint.color = Color.BLACK

        // inner circle with the indicator
        canvas?.drawCircle(pointPosition.x, pointPosition.y, radius / 12, paint)

        val labelRadius = radius + RADIUS_OFFSET_LABEL
        for (i in FanSpeed.values()) {
            pointPosition.computeXYForSpeed(i, labelRadius)
            val label = resources.getString(i.label)
            canvas?.drawText(label, pointPosition.x, pointPosition.y, paint)
        }
    }

    private fun updateContentDescription() {
        contentDescription = resources.getString(fanSpeed.label)
    }

    private fun PointF.computeXYForSpeed(fanSpeed: FanSpeed, markerRadius: Float) {
        // angles are in radians
        val startAngle = Math.PI * (9 / 8.0)
        val angle = startAngle + fanSpeed.ordinal * (Math.PI / 4)
        x = (markerRadius * cos(angle)).toFloat() + width / 2
        y = (markerRadius * sin(angle)).toFloat() + height / 2
    }

    fun getCurrentFanSpeed(): Int {
        return fanSpeed.ordinal
    }
}

enum class FanSpeed(val label: Int) {
    OFF(R.string.fan_off),
    LOW(R.string.fan_low),
    MEDIUM(R.string.fan_medium),
    HIGH(R.string.fan_high);

    fun next() = when (this) {
        OFF -> LOW
        LOW -> MEDIUM
        MEDIUM -> HIGH
        HIGH -> OFF
    }
}

private const val RADIUS_OFFSET_LABEL = 50          //Offset from dial radius to draw text label
private const val RADIUS_OFFSET_INDICATOR = -50     //Offset from dial radius to draw indicator