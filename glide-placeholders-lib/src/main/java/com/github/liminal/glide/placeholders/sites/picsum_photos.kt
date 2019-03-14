package com.github.liminal.glide.placeholders.sites

import android.net.Uri

private const val SITE_URL = "https://picsum.photos/"

/**
 * Placeholder for site https://picsum.photos/
 */
data class LoremPicsum(
    val grayscale: Boolean = false,
    val imageId: Int? = null,
    val blur : Boolean = false,
    val random: Boolean = false,
    val gravity: CropGravity? = null
) : AbsBaseSiteModel(Uri.parse(SITE_URL)) {

    enum class CropGravity { north, east, south, west, center }

    override fun Uri.Builder.buildUrl(width: Int, height: Int) {
        if (grayscale) appendPath("g")
        appendPath("$width")
        appendPath("$height")
        imageId?.let { appendQueryParameter("image", "$it") }
        gravity?.let { appendQueryParameter("gravity", it.name) }
        if (random) appendQueryParameter("random", "")
        if (blur) appendQueryParameter("blur", "")
    }

}


