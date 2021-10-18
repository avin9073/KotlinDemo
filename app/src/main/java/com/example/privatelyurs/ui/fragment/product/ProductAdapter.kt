package com.example.privatelyurs.ui.fragment.product

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.privatelyurs.R
import com.example.privatelyurs.databinding.LayoutSingleHomeItemBinding
import com.example.privatelyurs.databinding.LayoutSingleProductItemBinding
import com.example.privatelyurs.databinding.LayoutSingleWishlistItemBinding
import com.example.privatelyurs.model.entity.CategoryItem_List
import com.example.privatelyurs.model.entity.ProductItem_List
import com.example.privatelyurs.model.entity.WishlistItem_List
import com.example.privatelyurs.ui.fragment.category.CategoryItemAdapter
import com.example.privatelyurs.ui.fragment.wishlist.WishlistItemAdapter
import java.util.ArrayList

class ProductAdapter (
    private val context: Context,
    private val arrayList: ArrayList<ProductItem_List>,
    var productlistListener: ProductlistListener
) : RecyclerView.Adapter<ProductAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: LayoutSingleProductItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.layout_single_product_item, parent, false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.tvItemName.text = arrayList[position].Item_name
        holder.binding.tvItemPriceText.text = arrayList[position].Item_Price
        holder.binding.tvItemOldpriceText.text = arrayList[position].Item_Old_Price
        holder.binding.tvItemDiscText.text = arrayList[position].Item_Discount

        holder.itemView.setOnClickListener(View.OnClickListener {
            productlistListener.onItemClick(arrayList[position])
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

    inner class ViewHolder(binding_: LayoutSingleProductItemBinding) : RecyclerView.ViewHolder(binding_.root) {

        val binding: LayoutSingleProductItemBinding = binding_

    }

    interface ProductlistListener{
        fun onItemClick(productitemList: ProductItem_List)

    }


}