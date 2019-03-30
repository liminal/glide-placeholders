package com.example.glideplaceholders.app.data

import com.example.glideplaceholders.app.dpToPx
import com.github.liminal.glide.placeholders.ImagePlaceHolderModel
import com.github.liminal.glide.placeholders.fixedSize
import com.github.liminal.glide.placeholders.maxSize
import com.github.liminal.glide.placeholders.sites.BaconMockup
import com.github.liminal.glide.placeholders.sites.BaseKitten
import com.github.liminal.glide.placeholders.sites.DummyImage
import com.github.liminal.glide.placeholders.sites.DummySrc
import com.github.liminal.glide.placeholders.sites.ImgPlaceHolder
import com.github.liminal.glide.placeholders.sites.LoremFlickr
import com.github.liminal.glide.placeholders.sites.LoremPicsum
import com.github.liminal.glide.placeholders.sites.PlaceBear
import com.github.liminal.glide.placeholders.sites.PlaceBeard
import com.github.liminal.glide.placeholders.sites.PlaceHolder
import com.github.liminal.glide.placeholders.sites.PlaceImg
import com.github.liminal.glide.placeholders.sites.PlaceKitten
import com.github.liminal.glide.placeholders.sites.StevenSeagallery
import java.util.*


object PlaceHolderBag {

    /**
     * An array of sample (dummy) items.
     */
    val ITEMS: List<Group<ImagePlaceHolderModel>> =
        listOf(
            group("wrappers") {
                name = "Wrappers"

                entry("1") {
                    description = "imgplaceholder"
                    item = PlaceKitten(

                    ).maxSize(maxWidth = 250.dpToPx)
                }
            },
            kittenGroup("placekitten", "placekitten.com", ::PlaceKitten),
            kittenGroup("placebear", "placebear.com", ::PlaceBear),
            kittenGroup("steven_seagallery", "stevenseagallery.com", ::StevenSeagallery),
            kittenGroup("placebeard", "placebeard.it", ::PlaceBeard),
            group("lorem_picsum") {
                name = "Lorem Picsum"

                entry("lorem_picsum_1") {
                    description = "Lorem Picsum example"
                    item = LoremPicsum(
                        grayscale = false,
                        blur = false
                    )
                }
            },
            group("baconmock") {
                name = "Bacon Mockup"

                entry("1") {
                    description = "Bacon Mockup"
                    item = BaconMockup
                }
           },
            group("fixed size_baconmock") {
                name = "Bacon Mockup Fixed Size"

                entry("1") {
                    description = "Bacon Mockup Fixed"
                    item = BaconMockup.fixedSize(width = 300, height = 300)
                }
           },
            group("imgplaceholder") {
                name = "ImgPlaceHolder"

                entry("1") {
                    description = "imgplaceholder"
                    item = ImgPlaceHolder(

                    )
                }
            },
            group("placeholder") {
                name = "PlaceHolder"

                entry("1") {
                    description = "placeholder"
                    item = PlaceHolder(

                    )
                }
            },
            group("dummyimage") {
                name = "Dummy Image"

                entry("1") {
                    description = "dummyimg"
                    item = DummyImage(

                    )
                }
            },
            group("placeimg") {
                name = "PlaceIMG"

                entry("1") {
                    description = "default"
                    item = PlaceImg()
                }

                entry("2") {
                    description = "category: Architecture"
                    item =
                        PlaceImg(category = PlaceImg.Category.ARCHITECTURE)
                }

                entry("3") {
                    description = "filters: sepia"
                    item =
                        PlaceImg(filter = PlaceImg.Filter.SEPIA)
                }
            },
            group("loremflickr") {
                name = "Lorem Flickr"

                entry("1") {
                    description = "default"
                    item = LoremFlickr()
                }

                entry("keyword_paris") {
                    description = "keyword: paris"
                    item =
                        LoremFlickr(keywords = listOf("paris"))
                }

                entry("keywords_multiple") {
                    description = "keywords: paris, girl"
                    item = LoremFlickr(
                        keywords = listOf(
                            "paris",
                            "girl"
                        )
                    )
                }
            },
            group("dummysrc") {
                name = "Dummy Src"

                entry("1") {
                    description = "default"
                    item = DummySrc()
                }

                entry("red_bg") {
                    description = "background: red"
                    item =
                        DummySrc(backgroundColor = 0xFF0000)
                }
            }
        )

    /**
     * A map of sample (dummy) items, by key.
     */
    val ITEM_MAP: MutableMap<String, GroupEntry<ImagePlaceHolderModel>> = HashMap()


    init {

        ITEMS.forEach { group ->
            group.items.forEach { entry -> ITEM_MAP[entry.key] = entry }
        }

    }

    private fun kittenGroup(key: String, groupName: String, kittenMaker: (Boolean) -> BaseKitten) =
        group<ImagePlaceHolderModel>(key) {
            name = groupName

            entry("color") {
                description = "$groupName color variant"
                item = kittenMaker(false)
            }

            entry("gray") {
                description = "$groupName grayscale variant"
                item = kittenMaker(true)
            }

        }

}

