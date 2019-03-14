package com.github.liminal.glide.placeholders.sites

import android.net.Uri

private const val SITE_URL = "https://baconmockup.com/"

/**
 * Placeholder for site https://baconmockup.com/
 */
object BaconMockup : BaseKitten(Uri.parse(SITE_URL)) {
    override val grayscale: Boolean = false

}