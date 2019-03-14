package com.example.glideplaceholders.app

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import com.github.liminal.glide.placeholders.ImagePlaceHolderModel
import com.github.liminal.glide.placeholders.PlaceHolderImageLoader
import java.io.InputStream

@GlideModule
class ExampleAppGlideModule : AppGlideModule() {

    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        registry.prepend(ImagePlaceHolderModel::class.java, InputStream::class.java, PlaceHolderImageLoader.Factory())
    }
}