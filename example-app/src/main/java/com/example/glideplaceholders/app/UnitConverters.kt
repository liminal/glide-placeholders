package com.example.glideplaceholders.app

import android.content.res.Resources
import android.util.TypedValue
import kotlin.math.roundToInt

private object UnitConstants {
    val displayMetrics by lazy { Resources.getSystem().displayMetrics }
}

val Float.dpToPx: Float get() = convertToUnit(TypedValue.COMPLEX_UNIT_DIP )

val Int.dpToPx: Int get() = this.toFloat().dpToPx.roundToInt()



private fun Float.convertToUnit(unit: Int): Float =
    TypedValue.applyDimension(unit, this, UnitConstants.displayMetrics)
