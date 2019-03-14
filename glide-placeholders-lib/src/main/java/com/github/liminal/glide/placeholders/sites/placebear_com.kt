package com.github.liminal.glide.placeholders.sites

import android.net.Uri

private const val SITE_URL = "https://placebear.com/"

/**
 * Placeholder for site https://placebear.com/
 */
data class PlaceBear(override val grayscale: Boolean = false) : BaseKitten(Uri.parse(
    SITE_URL
))