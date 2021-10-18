package com.example.privatelyurs.ui.fragment.addressbook

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.privatelyurs.R
import com.example.privatelyurs.databinding.AddressbookFragmentBinding
import com.example.privatelyurs.databinding.CategoryFragmentBinding
import com.example.privatelyurs.model.entity.AddressBook_List
import com.example.privatelyurs.model.entity.CategoryItem_List
import com.example.privatelyurs.model.entity.OrderItem_List
import com.example.privatelyurs.ui.activity.dashboard.DashboardActivity
import com.example.privatelyurs.ui.fragment.category.CategoryItemAdapter
import com.example.privatelyurs.ui.fragment.category.CategoryfragmentViewModel
import com.example.privatelyurs.ui.fragment.orders.OrderAdapter
import com.example.privatelyurs.ui.fragment.orders.OrderFragment
import org.koin.androidx.viewmodel.ext.android.getViewModel
import java.util.ArrayList

class AddressBookFragment : Fragment() {

    private lateinit var viewModel: AddressBookViewModel
    private lateinit var binding : AddressbookFragmentBinding
    private var arraylist = ArrayList<AddressBook_List>()
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var addressBookAdapter: AddressBookAdapter

    companion object {
        fun newInstance() =
            AddressBookFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.addressbook_fragment, container, false)
        viewModel= getViewModel()


        return binding.root
    }

    override fun onResume() {
        super.onResume()

        (activity as DashboardActivity).setToolbarVisibility(true)
        (activity as DashboardActivity).setBackButton(true)
        (activity as DashboardActivity).setBottomTabVisibility(false)
        (activity as DashboardActivity).setToolbarActionButtonVisibility(false)
        (activity as DashboardActivity).setToolbarTitle(getString(R.string.address_book))
    }

    @SuppressLint("FragmentLiveDataObserve")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initHomeRecycler()

        binding.viewmodel = viewModel
    }

    private fun initHomeRecycler() {

        arraylist = ArrayList()
        linearLayoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvAddressbook.layoutManager = linearLayoutManager
        addressBookAdapter =
            AddressBookAdapter(requireContext(), arraylist)
        binding.rvAddressbook.adapter = addressBookAdapter

        arraylist.add(AddressBook_List("Jenny Buffet","Akshay Nagar 1st Block"))

    }


}