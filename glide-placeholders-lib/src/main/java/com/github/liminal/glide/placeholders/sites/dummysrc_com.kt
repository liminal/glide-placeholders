package com.github.liminal.glide.placeholders.sites

import android.net.Uri

private const val SITE_URL = "https://www.dummysrc.com"

/**
 * Placeholder from site https://www.dummysrc.com
 */
data class DummySrc(
    val backgroundColor: Int? = null,
    val fontColor: Int? = null
) : AbsBaseSiteModel(Uri.parse(SITE_URL)) {

    override fun Uri.Builder.buildUrl(width: Int, height: Int) {
        appendPath("${width}x$height")
        if (backgroundColor != null) {
            appendPath(Integer.toHexString(backgroundColor))
            if (fontColor != null) appendPath(Integer.toHexString((fontColor)))
        }

    }

}


