package com.example.privatelyurs.ui.fragment.orders

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.privatelyurs.R
import com.example.privatelyurs.databinding.LayoutOrderlistBinding

import com.example.privatelyurs.model.entity.OrderItem_List
import com.example.privatelyurs.model.entity.WishlistItem_List
import java.util.ArrayList

class OrderAdapter (private val context: Context,
private val arrayList: ArrayList<OrderItem_List>,
        var orderlistListener: OrderlistListener
) : RecyclerView.Adapter<OrderAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: LayoutOrderlistBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.layout_orderlist, parent, false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.tvItemName.text = arrayList[position].Item_name
        holder.binding.tvItemPriceText.text = arrayList[position].Item_Price
        holder.binding.tvItemOldpriceText.text = arrayList[position].Item_Old_Price
        holder.binding.tvItemDelivery.text = arrayList[position].Item_Delivery

        holder.itemView.setOnClickListener(View.OnClickListener {
            orderlistListener.onItemClick(arrayList[position])
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

    inner class ViewHolder(binding_: LayoutOrderlistBinding) : RecyclerView.ViewHolder(binding_.root) {

        val binding: LayoutOrderlistBinding = binding_

    }

    interface OrderlistListener{
        fun onItemClick(orderitemList: OrderItem_List)

    }


}