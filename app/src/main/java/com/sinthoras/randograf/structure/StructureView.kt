package com.sinthoras.randograf.structure

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import kotlin.jvm.JvmOverloads

class StructureView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        setWillNotDraw(false)
    }

    private var structure: Structure? = null
    private val paint = Paint()

    fun setStructure(structure: Structure) {
        this.structure = structure
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        structure?.draw(context, canvas, paint)
    }
}
