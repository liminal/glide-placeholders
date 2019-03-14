package com.github.liminal.glide.placeholders.sites

import android.net.Uri

private const val SITE_URL = "https://placekitten.com/"

/**
 * Placeholder for site https://placekitten.com/
 */
data class PlaceKitten(override val grayscale: Boolean = false) : BaseKitten(Uri.parse(
    SITE_URL
))


/**
 * Many sites use the formula based on placekitten.com which is
 * URL/(g)/width/height
 *
 * so this helper makes it easy to add more like it
 */
abstract class BaseKitten(baseUrl: Uri) : AbsBaseSiteModel(baseUrl) {
    abstract val grayscale: Boolean

    override fun Uri.Builder.buildUrl(width: Int, height: Int) {
        if (grayscale) appendPath("g")
        appendPath("$width")
        appendPath("$height")
    }

}
