package com.github.liminal.glide.placeholders.sites

import android.net.Uri
import com.github.liminal.glide.placeholders.ImagePlaceHolderModel

abstract class AbsBaseSiteModel(val baseUrl: Uri) :
    ImagePlaceHolderModel {

    abstract fun Uri.Builder.buildUrl(width: Int, height: Int)

    override fun url(width: Int, height: Int): String {
        return baseUrl.buildUpon()
            .apply { buildUrl(width, height) }
            .build()
            .toString()
    }
}