package com.github.liminal.glide.placeholders


fun <T : ImagePlaceHolderModel> T.fixedSize(
    width: Int? = null,
    height: Int? = null
): ImagePlaceHolderModel =
    placeHolderModel { w, h ->
        this.url(
            width = width ?: w,
            height = height ?: h
        )
    }


fun <T : ImagePlaceHolderModel> T.minSize(
    minWidth: Int = Int.MIN_VALUE,
    minHeight: Int = Int.MIN_VALUE
): ImagePlaceHolderModel =
    placeHolderModel { w, h ->
        this.url(
            width = maxOf(w, minWidth),
            height = maxOf(h, minHeight)
        )
    }

fun <T : ImagePlaceHolderModel> T.maxSize(
    maxWidth: Int = Int.MAX_VALUE,
    maxHeight: Int = Int.MAX_VALUE
): ImagePlaceHolderModel =
    placeHolderModel { w, h ->
        this.url(
            width = minOf(w, maxWidth),
            height = minOf(h, maxHeight)
        )
    }

fun <T : ImagePlaceHolderModel> T.scale(value: Float) =
        placeHolderModel { w, h ->
            this.url(
                width = (w * value).toInt(),
                height = (h * value).toInt()
            )
        }

