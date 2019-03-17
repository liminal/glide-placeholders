package com.github.liminal.glide.placeholders

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.Registry
import java.io.InputStream


/**
 * A {@link com.bumptech.glide.module.GlideModule} for to register PlaceHolderImageLoader
 * for apps not using annotations
 *
 * <p> If you're using gradle, you can include this module simply by depending on the aar, the
 * module will be merged in by manifest merger. For other build systems or for more more
 * information, see {@link com.bumptech.glide.module.GlideModule}. </p>
 *
 * @deprecated Replaced by {@link PlaceholderLibraryGlideModule} for Applications that use Glide's
 * annotations.
 */
@Deprecated("superceded by PlaceholderLibraryGlideModule for apps using annotations")
class PlaceholderGlideModule : com.bumptech.glide.module.GlideModule {
    override fun applyOptions(context: Context, builder: GlideBuilder) {
    }

    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        registry.prepend(ImagePlaceHolderModel::class.java, InputStream::class.java, PlaceHolderImageLoader.Factory())
    }

}