package com.example.glideplaceholders.app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.glideplaceholders.app.data.PlaceHolderBag
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_item_list.*
import kotlinx.android.synthetic.main.item_list.*

/**
 * An activity representing a list of Pings. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a [ItemDetailActivity] representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
class ItemListActivity : AppCompatActivity() {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private var twoPane: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_list)

        setSupportActionBar(toolbar)
        toolbar.title = title

        if (item_detail_container != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            twoPane = true
        }

        setupRecyclerView(item_list)
    }


    private fun setupRecyclerView(recyclerView: androidx.recyclerview.widget.RecyclerView) {

        val adapter = PlaceHolderListItemDelegateAdapter { action ->
            when (action) {
                is PlaceHolderEntryDelegate.Action.ClickAction -> onEntryClicked(action)
            }

        }

        val items = mutableListOf<PlaceHolderListItem>()

        PlaceHolderBag.ITEMS.forEach { group ->
            items.add(PlaceHolderListItem.HeaderItem(group.name))
            group.items.mapTo(items) { entry ->
                PlaceHolderListItem.EntryItem(
                    key = entry.key,
                    description = entry.description,
                    placeholder = entry.item
                )
            }
        }


        adapter.items = items
        recyclerView.adapter = adapter
    }

    private fun onEntryClicked(action: PlaceHolderEntryDelegate.Action.ClickAction) {
        val item = action.item
        if (twoPane) {
            val fragment = ItemDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ItemDetailFragment.ARG_ITEM_ID, item.key)
                }
            }
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.item_detail_container, fragment)
                .commit()
        } else {
            val intent = Intent(this, ItemDetailActivity::class.java).apply {
                putExtra(ItemDetailFragment.ARG_ITEM_ID, item.key)
            }
            startActivity(intent)
        }

    }

}
