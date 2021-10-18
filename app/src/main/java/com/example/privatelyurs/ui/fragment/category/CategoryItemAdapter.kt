package com.example.privatelyurs.ui.fragment.category

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.privatelyurs.R
import com.example.privatelyurs.databinding.LayoutCategoryItemBinding
import com.example.privatelyurs.databinding.LayoutSingleWishlistItemBinding
import com.example.privatelyurs.model.entity.CategoryItem_List
import com.example.privatelyurs.model.entity.OrderItem_List
import com.example.privatelyurs.model.entity.WishlistItem_List
import com.example.privatelyurs.ui.fragment.orders.OrderAdapter
import com.example.privatelyurs.ui.fragment.wishlist.WishlistItemAdapter
import java.util.ArrayList

class CategoryItemAdapter(
    private val context: Context,
    private val arrayList: ArrayList<CategoryItem_List>,
    var categorylistListener: CategorylistListener
) : RecyclerView.Adapter<CategoryItemAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: LayoutCategoryItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.layout_category_item, parent, false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.tvItemName.text = arrayList[position].Item_name

        holder.itemView.setOnClickListener(View.OnClickListener {
            categorylistListener.onItemClick(arrayList[position])
        })


        /*try {
            Glide.with(context)
                .load(arrayList[position].challenge_image_url)
                .apply(RequestOptions())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(circularProgressDrawable)
                .error(R.drawable.ic_challenge_tittle_placeholder)
                .into(holder.binding.ivCatIcon)
        } catch (e: Exception) {
            e.printStackTrace()
        }
*/

    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    inner class ViewHolder(binding_: LayoutCategoryItemBinding) : RecyclerView.ViewHolder(binding_.root) {

        val binding: LayoutCategoryItemBinding = binding_

    }

    interface CategorylistListener{
        fun onItemClick(categoryItemList: CategoryItem_List)

    }


}