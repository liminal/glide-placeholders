package com.github.liminal.glide.placeholders

interface ImagePlaceHolderModel {
    fun url(width: Int, height: Int): String
}

fun placeHolderModel(body: (w: Int, h: Int) -> String): ImagePlaceHolderModel =
    object : ImagePlaceHolderModel {
        override fun url(width: Int, height: Int): String = body(width, height)
    }
