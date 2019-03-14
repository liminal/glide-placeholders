package com.example.glideplaceholders.app.data


data class Group<T: Any>(
    val key: String,
    val name: String,
    val items: List<GroupEntry<T>>
) {

    @DataBuilder
    class Builder<T : Any>(
        var key: String ="") {
        var name = ""
        var items = mutableListOf<GroupEntry<T>>()

        fun entry(key: String, body: GroupEntry.Builder<T>.() -> Unit) {
            items.add(GroupEntry.Builder<T>("${this.key}/$key").apply(body).build())
        }

        fun build() = Group(
            key = key,
            name = name,
            items = items
        )
    }
}

fun <T  :Any> group(key: String, body: Group.Builder<T>.() -> Unit) : Group<T> {
    return Group.Builder<T>(key).apply(body).build()
}


data class GroupEntry<T>(
    val key: String,
    val description: String,
    val item: T
) {
    @DataBuilder
    class Builder<T: Any>(var key: String) {
        var description : String = ""
        lateinit var item : T

        fun build() : GroupEntry<T> =
                GroupEntry(
                    key = key,
                    description = description,
                    item = item
                )

    }
}

@DslMarker
annotation class DataBuilder


