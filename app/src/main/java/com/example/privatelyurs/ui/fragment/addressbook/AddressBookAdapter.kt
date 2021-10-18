package com.example.privatelyurs.ui.fragment.addressbook

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.privatelyurs.R
import com.example.privatelyurs.databinding.LayoutCategoryItemBinding
import com.example.privatelyurs.databinding.LayoutSingleAdddressBinding
import com.example.privatelyurs.model.entity.AddressBook_List
import com.example.privatelyurs.model.entity.CategoryItem_List
import com.example.privatelyurs.ui.fragment.category.CategoryItemAdapter
import java.util.ArrayList

class AddressBookAdapter (
    private val context: Context,
    private val arrayList: ArrayList<AddressBook_List>
) : RecyclerView.Adapter<AddressBookAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: LayoutSingleAdddressBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.layout_single_adddress, parent, false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.tvName.text = arrayList[position].Name
        holder.binding.tvAddress.text = arrayList[position].Address

    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    inner class ViewHolder(binding_: LayoutSingleAdddressBinding) : RecyclerView.ViewHolder(binding_.root) {

        val binding: LayoutSingleAdddressBinding = binding_

    }




}