package com.github.liminal.glide.placeholders.sites

import android.net.Uri

private const val SITE_URL = "https://placeimg.com/"

/**
 * Placeholder from site https://placeimg.com/
 *
 */
data class PlaceImg(
    val category: Category? = null,
    val filter: Filter? = null
) : AbsBaseSiteModel(Uri.parse(SITE_URL)) {

    enum class Category(val text: String) {
        ANIMALS("animals"),
        ARCHITECTURE("arch"),
        NATURE("nature"),
        PEOPLE("people"),
        TECH("tech")
    }

    enum class Filter(val text: String) {
        GRAYSCALE("grayscale"),
        SEPIA("sepia")
    }

    override fun Uri.Builder.buildUrl(width: Int, height: Int) {
        appendPath("$width")
        appendPath("$height")

        if (category != null) appendPath(category.text)
        if (filter != null) appendPath(filter.text)
    }

}


