package com.example.glideplaceholders.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.github.liminal.glide.placeholders.ImagePlaceHolderModel

sealed class PlaceHolderListItem {
    data class HeaderItem(val title: String) : PlaceHolderListItem()
    data class EntryItem(
        val key: String,
        val placeholder: ImagePlaceHolderModel,
        val description: String
    ): PlaceHolderListItem()
}

interface AdapterAction

typealias AdapterActionCallbacks = (AdapterAction) -> Unit

class PlaceHolderListItemDelegateAdapter(
    callbacks : AdapterActionCallbacks
) : ListDelegationAdapter<List<Any>>() {

    init {
        delegatesManager.addDelegate(PlaceHolderHeaderDelegate())
            .addDelegate(PlaceHolderEntryDelegate(callbacks))
    }

}

class PlaceHolderHeaderDelegate : AbsListItemAdapterDelegate<PlaceHolderListItem.HeaderItem, Any, PlaceHolderHeaderDelegate.ViewHolder>() {
    override fun isForViewType(item: Any, items: MutableList<Any>, position: Int): Boolean {
        return item is PlaceHolderListItem.HeaderItem
    }

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.placeholder_list_header_item, parent,false))
    }


    override fun onBindViewHolder(
        item: PlaceHolderListItem.HeaderItem,
        holder: ViewHolder,
        payloads: MutableList<Any>
    ) {
        holder.title.text = item.title
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.title)
    }
}

class PlaceHolderEntryDelegate(
    private val callbacks: AdapterActionCallbacks
) : AbsListItemAdapterDelegate<PlaceHolderListItem.EntryItem, Any, PlaceHolderEntryDelegate.ViewHolder>() {

    sealed class Action : AdapterAction {
        data class ClickAction(val item: PlaceHolderListItem.EntryItem) : Action()
    }

    override fun isForViewType(item: Any, items: MutableList<Any>, position: Int): Boolean {
        return item is PlaceHolderListItem.EntryItem
    }

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.placeholder_list_entry_item, parent, false)
        )
    }


    override fun onBindViewHolder(
        item: PlaceHolderListItem.EntryItem,
        holder: ViewHolder,
        payloads: MutableList<Any>
    ) {
        holder.title.text = item.key
        holder.description.text = item.description

        Glide.with(holder.icon)
            .load(item.placeholder)
            .into(holder.icon)

        holder.itemView.setOnClickListener {
            callbacks(Action.ClickAction(item))
        }

    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val icon by lazy { view.findViewById<ImageView>(R.id.row_icon) }
        val title by lazy { view.findViewById<TextView>(R.id.row_title) }
        val description by lazy { view.findViewById<TextView>(R.id.row_description) }
    }

}