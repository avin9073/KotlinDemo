package com.example.DemoShopping.ui.fragment.productdetails

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.DemoShopping.R
import com.example.DemoShopping.databinding.LayoutSingleHomeItemBinding
import com.example.DemoShopping.model.entity.HomeSingleItem_List
import java.util.ArrayList

class ProductDetailsAdapter (
    private val context: Context,
    private val arrayList: ArrayList<HomeSingleItem_List>
) : RecyclerView.Adapter<ProductDetailsAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: LayoutSingleHomeItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.layout_single_home_item, parent, false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.tvItemName.text = arrayList[position].Item_name


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

    inner class ViewHolder(binding_: LayoutSingleHomeItemBinding) : RecyclerView.ViewHolder(binding_.root) {

        val binding: LayoutSingleHomeItemBinding = binding_

    }


}