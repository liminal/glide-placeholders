package com.github.liminal.glide.placeholders.sites

import android.net.Uri

private const val SITE_URL = "https://stevensegallery.com/"

/**
 * Placeholder for site https://www.stevensegallery.com/
 */
data class StevenSeagallery(override val grayscale: Boolean = false) : BaseKitten(Uri.parse(
    SITE_URL
))