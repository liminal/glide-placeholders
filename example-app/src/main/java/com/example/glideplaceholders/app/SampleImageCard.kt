package com.example.glideplaceholders.app

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.card.MaterialCardView

class SampleImageCard @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : MaterialCardView(context, attrs, defStyleAttr) {


    val superTitle: TextView
    val image: ImageView
    val caption: TextView

    init {
        inflate(context, R.layout.sample_image_card, this)

        superTitle = findViewById(R.id.sample_title)
        image = findViewById(R.id.sample_image)
        caption = findViewById(R.id.sample_caption)

        val a: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.SampleImageCard)

        val imgW = a.getDimensionPixelSize(R.styleable.SampleImageCard_imgWidth, 0)
        val imgH = a.getDimensionPixelSize(R.styleable.SampleImageCard_imgHeight, 0)

        val capText = a.getString(R.styleable.SampleImageCard_sampleCaption)

        val p = image.layoutParams
        p.width = imgW
        p.height = imgH
        image.layoutParams = p

        val txt = "size: ${imgW} x ${imgH}"
        superTitle.text = txt

        caption.text = capText ?: ""

        a.recycle()

    }

}