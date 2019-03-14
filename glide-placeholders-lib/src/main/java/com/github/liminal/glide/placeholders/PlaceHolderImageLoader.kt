package com.github.liminal.glide.placeholders

import com.bumptech.glide.load.Options
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.ModelLoader
import com.bumptech.glide.load.model.ModelLoaderFactory
import com.bumptech.glide.load.model.MultiModelLoaderFactory
import com.bumptech.glide.load.model.stream.BaseGlideUrlLoader
import java.io.InputStream

class PlaceHolderImageLoader(
    urlLoader: ModelLoader<GlideUrl, InputStream>
) : BaseGlideUrlLoader<ImagePlaceHolderModel>(urlLoader) {

    override fun handles(model: ImagePlaceHolderModel): Boolean = true

    override fun getUrl(model: ImagePlaceHolderModel, width: Int, height: Int, options: Options?): String {
        return model.url(width, height)
    }

    class Factory : ModelLoaderFactory<ImagePlaceHolderModel, InputStream> {

        override fun build(multiFactory: MultiModelLoaderFactory): ModelLoader<ImagePlaceHolderModel, InputStream> {
            return PlaceHolderImageLoader(
                multiFactory.build(GlideUrl::class.java, InputStream::class.java)
            )
        }

        override fun teardown() {
        }

    }
}