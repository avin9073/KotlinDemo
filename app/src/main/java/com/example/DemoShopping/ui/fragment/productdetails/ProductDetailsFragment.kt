package com.example.DemoShopping.ui.fragment.productdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.DemoShopping.R
import com.example.DemoShopping.databinding.ProductdetailsFragmentBinding
import com.example.DemoShopping.model.entity.HomeSingleItem_List
import com.example.DemoShopping.ui.activity.dashboard.DashboardActivity
import org.koin.androidx.viewmodel.ext.android.getViewModel
import java.util.ArrayList

class ProductDetailsFragment : Fragment() {

    private lateinit var viewModel: ProductDetailsViewModel
    private lateinit var binding : ProductdetailsFragmentBinding
    private var arraylist = ArrayList<HomeSingleItem_List>()
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var productDetailsAdapter: ProductDetailsAdapter

    companion object {
        fun newInstance() =
            ProductDetailsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.productdetails_fragment, container, false)
        viewModel= getViewModel()


        return binding.root
    }

    override fun onResume() {
        super.onResume()
        (activity as DashboardActivity).setToolbarVisibility(true)
        (activity as DashboardActivity).setBackButton(true)
        (activity as DashboardActivity).setBottomTabVisibility(false)
        (activity as DashboardActivity).setToolbarTitle(getString(R.string.product_details))
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        iniRelatedProductsRecycler()

    }

    private fun iniRelatedProductsRecycler() {

        arraylist = ArrayList<HomeSingleItem_List>()
        linearLayoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvHorizontallist.layoutManager = linearLayoutManager
        productDetailsAdapter =
            ProductDetailsAdapter(requireContext(), arraylist)

        binding.rvHorizontallist.adapter = productDetailsAdapter

        arraylist.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 1","900.00","1000.00","25% OFF"))
        arraylist.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 2","1900.00","2000.00","20% OFF"))
        arraylist.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 3","2900.00","3000.00","15% OFF"))
        arraylist.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 4","3900.00","4000.00","10% OFF"))
        arraylist.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 5","4900.00","5000.00","25% OFF"))
        arraylist.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 6","5900.00","6000.00","20% OFF"))
        arraylist.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 7","6900.00","7000.00","15% OFF"))
        arraylist.add(HomeSingleItem_List(R.drawable.login_back_image,"Item 8","7900.00","8000.00","10% OFF"))

    }


}