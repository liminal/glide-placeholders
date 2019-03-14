package com.github.liminal.glide.placeholders.sites

import android.net.Uri

private const val SITE_URL = "https://via.placeholder.com/"

/**
 * Placeholder from site https://placeholder.com/
 */
data class PlaceHolder(
    val backgroundColor: Int? = null,
    val fontColor: Int? = null,
    val message : String? = null
) : AbsBaseSiteModel(Uri.parse(SITE_URL)) {

    override fun Uri.Builder.buildUrl(width: Int, height: Int) {
        appendPath("${width}x${height}")
        if (backgroundColor != null) appendPath(Integer.toHexString(backgroundColor)) else if (fontColor != null) appendPath("cccccc")
        if (fontColor != null) appendPath(Integer.toHexString(fontColor))

        if (message != null) appendQueryParameter("Text", message)
    }

}


