package com.github.liminal.glide.placeholders.sites

import android.net.Uri

private const val SITE_URL = "https://placebeard.it"

/**
 * Placeholder for site https://placebeard.it
 */
data class PlaceBeard(override val grayscale: Boolean = false) : BaseKitten(Uri.parse(
    SITE_URL
))