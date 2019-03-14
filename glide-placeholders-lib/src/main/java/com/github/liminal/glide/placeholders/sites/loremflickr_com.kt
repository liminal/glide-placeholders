package com.github.liminal.glide.placeholders.sites

import android.net.Uri

private const val SITE_URL = "https://loremflickr.com/"

/**
 * Placeholder from site https://loremflickr.com/
 *
 */
data class LoremFlickr(
    val grayscale: Boolean = false,
    val keywords: List<String>? = null,
    val matchAllKeywords: Boolean = false,
    val lock : Int? = null,
    val random : Int? = null
) : AbsBaseSiteModel(Uri.parse(SITE_URL)) {

    override fun Uri.Builder.buildUrl(width: Int, height: Int) {
        if (grayscale) appendPath("g")
        appendPath("$width")
        appendPath("$height")
        if (!keywords.isNullOrEmpty()) {
            appendPath(keywords.joinToString())
            if (matchAllKeywords) appendPath("all")
        }

        if (lock != null) appendQueryParameter("lock", "$lock")
        if (random != null) appendQueryParameter("random", "$random")

    }

}


