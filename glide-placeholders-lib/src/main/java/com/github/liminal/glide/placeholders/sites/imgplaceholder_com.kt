package com.github.liminal.glide.placeholders.sites

import android.net.Uri

private const val SITE_URL = "https://imgplaceholder.com/"

/**
 * Placeholder from site https://imgplaceholder.com/
 *
 */
data class ImgPlaceHolder(
    val backgroundColor: Int? = null,
    val fontColor: Int? = null,
    val message : String? = null
) : AbsBaseSiteModel(Uri.parse(SITE_URL)) {

    override fun Uri.Builder.buildUrl(width: Int, height: Int) {
        appendPath("${width}x${height}")
        if (backgroundColor != null) appendPath(Integer.toHexString(backgroundColor)) else if (fontColor != null) appendPath("cccccc")
        if (fontColor != null) appendPath(Integer.toHexString(fontColor))

        if (message != null) appendQueryParameter("text", message)
    }

}


