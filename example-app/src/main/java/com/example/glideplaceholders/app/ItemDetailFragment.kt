package com.example.glideplaceholders.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.glideplaceholders.app.data.GroupEntry
import com.example.glideplaceholders.app.data.PlaceHolderBag
import kotlinx.android.synthetic.main.activity_item_detail.*
import kotlinx.android.synthetic.main.item_detail.view.*
import com.github.liminal.glide.placeholders.ImagePlaceHolderModel

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a [ItemListActivity]
 * in two-pane mode (on tablets) or a [ItemDetailActivity]
 * on handsets.
 */
class ItemDetailFragment : Fragment() {

    /**
     * The dummy content this fragment is presenting.
     */
    private var item: GroupEntry<ImagePlaceHolderModel>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            if (it.containsKey(ARG_ITEM_ID)) {
                // Load the dummy content specified by the fragment
                // arguments. In a real-world scenario, use a Loader
                // to load content from a content provider.
                item = it.getString(ARG_ITEM_ID)?.let {  key -> PlaceHolderBag.ITEM_MAP[key] }
                activity?.toolbar_layout?.title = item?.key
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.item_detail, container, false)

        // Show the dummy content as text in a TextView.
        item?.let {
            rootView.image_1.loadImage(it.item)
            rootView.image_2.loadImage(it.item)
            rootView.image_3.loadImage(it.item)
        }

        return rootView
    }

    private fun ImageView.loadImage(model: ImagePlaceHolderModel) {
        Glide.with(this)
            .load(model)
            .apply(RequestOptions()
                .placeholder(loader().also { it.start() })
                .error(R.drawable.ic_error_black_24dp)
            )
            .into(this)

    }

    private fun loader() =
        CircularProgressDrawable(context!!).apply {
            strokeWidth = 5f
            centerRadius = 30f
        }

    companion object {
        /**
         * The fragment argument representing the item ID that this fragment
         * represents.
         */
        const val ARG_ITEM_ID = "item_id"
    }

}
