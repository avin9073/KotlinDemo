package com.example.privatelyurs.ui.fragment.orders

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
import com.example.privatelyurs.databinding.OrdersFragmentBinding
import com.example.privatelyurs.model.entity.OrderItem_List
import com.example.privatelyurs.ui.activity.dashboard.DashboardActivity
import com.example.privatelyurs.ui.fragment.orderdetails.OrderDetailsFragment
import com.example.privatelyurs.ui.fragment.wishlist.WishListFragment
import org.koin.androidx.viewmodel.ext.android.getViewModel
import java.util.ArrayList

class OrderFragment : Fragment(),OrderAdapter.OrderlistListener {

    private lateinit var viewModel: OrderViewModel
    private lateinit var binding : OrdersFragmentBinding
    private var arraylist = ArrayList<OrderItem_List>()
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var orderAdapter: OrderAdapter

    companion object {
        fun newInstance() =
            OrderFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.orders_fragment, container, false)
        viewModel= getViewModel()


        return binding.root
    }

    override fun onResume() {
        super.onResume()

        (activity as DashboardActivity).setToolbarVisibility(true)
        (activity as DashboardActivity).setBackButton(true)
        (activity as DashboardActivity).setBottomTabVisibility(false)
        (activity as DashboardActivity).setToolbarTitle(getString(R.string.orders))
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
        binding.rvOrders.layoutManager = linearLayoutManager
        orderAdapter =
            OrderAdapter(requireContext(), arraylist,this)
        binding.rvOrders.adapter = orderAdapter

        arraylist.add(OrderItem_List(R.drawable.login_back_image,"Delivered","Item 1","900.00","1000.00"))
        arraylist.add(OrderItem_List(R.drawable.login_back_image,"Delivered","Item 1","900.00","1000.00"))
        arraylist.add(OrderItem_List(R.drawable.login_back_image,"Delivered","Item 1","900.00","1000.00"))
        arraylist.add(OrderItem_List(R.drawable.login_back_image,"Delivered","Item 1","900.00","1000.00"))
        arraylist.add(OrderItem_List(R.drawable.login_back_image,"Delivered","Item 1","900.00","1000.00"))
        arraylist.add(OrderItem_List(R.drawable.login_back_image,"Delivered","Item 1","900.00","1000.00"))


    }

    override fun onItemClick(orderitemList: OrderItem_List) {
        showOrderDetailsPage()
    }


    private fun showOrderDetailsPage() {

        (activity as DashboardActivity).addFragment(
            OrderDetailsFragment.newInstance() as Fragment
        )
    }


}