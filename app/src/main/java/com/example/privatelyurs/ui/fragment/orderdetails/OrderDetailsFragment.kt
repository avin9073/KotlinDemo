package com.example.privatelyurs.ui.fragment.orderdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.privatelyurs.R
import com.example.privatelyurs.databinding.OrderdetailsFragmentBinding
import com.example.privatelyurs.databinding.ProfileDetailsFragmentBinding
import com.example.privatelyurs.ui.activity.dashboard.DashboardActivity
import com.example.privatelyurs.ui.fragment.profiledetails.ProfileDetailsViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel


class OrderDetailsFragment : Fragment() {

    private lateinit var viewModel: OrderDetailsViewModel
    private lateinit var binding: OrderdetailsFragmentBinding

    companion object {
        fun newInstance() =
            OrderDetailsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.orderdetails_fragment, container, false)
        viewModel = getViewModel()



        return binding.root
    }

    override fun onResume() {
        super.onResume()

        (activity as DashboardActivity).setToolbarVisibility(true)
        (activity as DashboardActivity).setBackButton(true)
        (activity as DashboardActivity).setBottomTabVisibility(false)
        (activity as DashboardActivity).setToolbarTitle(getString(R.string.order_details))

    }


}