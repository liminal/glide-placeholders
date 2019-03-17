package com.github.liminal.glide.placeholders

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.LibraryGlideModule
import java.io.InputStream

@GlideModule
class PlaceholderLibraryGlideModule : LibraryGlideModule() {

    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        registry.prepend(ImagePlaceHolderModel::class.java, InputStream::class.java, PlaceHolderImageLoader.Factory())
    }
}