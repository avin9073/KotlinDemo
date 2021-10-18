package com.example.privatelyurs.ui.fragment.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.privatelyurs.R
import com.example.privatelyurs.databinding.LayoutHomeItemlistBinding
import com.example.privatelyurs.model.entity.HomeItem_List
import com.example.privatelyurs.model.entity.HomeSingleItem_List
import java.util.*


class HomeAdapter (
    private val context: Context,
    private val arrayList: ArrayList<HomeItem_List>
) : RecyclerView.Adapter<HomeAdapter.ViewHolder>(){




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: LayoutHomeItemlistBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.layout_home_itemlist, parent, false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder.binding.tvItemCaption.text = arrayList[position].Item_name

        val homeItemlistAdapter = HomeItemlistAdapter(context, arrayList)

        holder.binding.rvHorizontallist.setHasFixedSize(true)
        holder.binding.rvHorizontallist.setLayoutManager(
            LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL, false
            )
        )
        holder.binding.rvHorizontallist.setAdapter(homeItemlistAdapter)

        val arrayListt: ArrayList<HomeSingleItem_List> = ArrayList()

        if (arrayList.get(position).Item_name.equals("Category1")) {
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 1","900.00","1000.00","25% OFF"))
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 2","1900.00","2000.00","20% OFF"))
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 3","2900.00","3000.00","15% OFF"))
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 4","3900.00","4000.00","10% OFF"))
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 5","4900.00","5000.00","25% OFF"))
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 6","5900.00","6000.00","20% OFF"))
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 7","6900.00","7000.00","15% OFF"))
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 8","7900.00","8000.00","10% OFF"))
        }

        if (arrayList.get(position).Item_name.equals("Category2")) {
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 1","900.00","1000.00","25% OFF"))
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 2","1900.00","2000.00","20% OFF"))
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 3","2900.00","3000.00","15% OFF"))
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 4","3900.00","4000.00","10% OFF"))
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 5","4900.00","5000.00","25% OFF"))
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 6","5900.00","6000.00","20% OFF"))
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 7","6900.00","7000.00","15% OFF"))
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 8","7900.00","8000.00","10% OFF"))
        }

        if (arrayList.get(position).Item_name.equals("Category3")) {
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 1","900.00","1000.00","25% OFF"))
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 2","1900.00","2000.00","20% OFF"))
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 3","2900.00","3000.00","15% OFF"))
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 4","3900.00","4000.00","10% OFF"))
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 5","4900.00","5000.00","25% OFF"))
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 6","5900.00","6000.00","20% OFF"))
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 7","6900.00","7000.00","15% OFF"))
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 8","7900.00","8000.00","10% OFF"))
        }
        if (arrayList.get(position).Item_name.equals("Category4")) {
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 1","900.00","1000.00","25% OFF"))
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 2","1900.00","2000.00","20% OFF"))
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 3","2900.00","3000.00","15% OFF"))
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 4","3900.00","4000.00","10% OFF"))
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 5","4900.00","5000.00","25% OFF"))
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 6","5900.00","6000.00","20% OFF"))
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 7","6900.00","7000.00","15% OFF"))
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 8","7900.00","8000.00","10% OFF"))
        }
        if (arrayList.get(position).Item_name.equals("Category5")) {
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 1","900.00","1000.00","25% OFF"))
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 2","1900.00","2000.00","20% OFF"))
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 3","2900.00","3000.00","15% OFF"))
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 4","3900.00","4000.00","10% OFF"))
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 5","4900.00","5000.00","25% OFF"))
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 6","5900.00","6000.00","20% OFF"))
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 7","6900.00","7000.00","15% OFF"))
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 8","7900.00","8000.00","10% OFF"))
        }

        if (arrayList.get(position).Item_name.equals("Category6")) {
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 1","900.00","1000.00","25% OFF"))
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 2","1900.00","2000.00","20% OFF"))
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 3","2900.00","3000.00","15% OFF"))
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 4","3900.00","4000.00","10% OFF"))
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 5","4900.00","5000.00","25% OFF"))
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 6","5900.00","6000.00","20% OFF"))
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 7","6900.00","7000.00","15% OFF"))
            arrayListt.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 8","7900.00","8000.00","10% OFF"))
        }



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

    inner class ViewHolder(binding_: LayoutHomeItemlistBinding) : RecyclerView.ViewHolder(binding_.root) {

        val binding: LayoutHomeItemlistBinding = binding_

    }


}