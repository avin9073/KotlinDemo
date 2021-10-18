package com.example.privatelyurs.ui.fragment.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.privatelyurs.R
import com.example.privatelyurs.databinding.ProductFragmentBinding
import com.example.privatelyurs.model.entity.CategoryItem_List
import com.example.privatelyurs.model.entity.ProductItem_List
import com.example.privatelyurs.ui.activity.dashboard.DashboardActivity
import com.example.privatelyurs.ui.fragment.productdetails.ProductDetailsFragment
import com.example.privatelyurs.utils.GridSpacingItemDecoration
import org.koin.androidx.viewmodel.ext.android.getViewModel
import java.util.ArrayList

class ProductFragment : Fragment(),ProductAdapter.ProductlistListener {

    private lateinit var viewModel: ProductViewModel
    private lateinit var binding : ProductFragmentBinding
    private var arraylist = ArrayList<ProductItem_List>()
    private lateinit var gridLayoutManager: GridLayoutManager
    private lateinit var productAdapter: ProductAdapter


    companion object {
        fun newInstance() =
            ProductFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.product_fragment, container, false)
        viewModel= getViewModel()


        return binding.root
    }

    override fun onResume() {
        super.onResume()

        (activity as DashboardActivity).setToolbarVisibility(true)
        (activity as DashboardActivity).setBackButton(true)
        (activity as DashboardActivity).setBottomTabVisibility(false)
        (activity as DashboardActivity).setToolbarTitle(getString(R.string.products))
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        iniCategoryRecycler()

    }

    private fun iniCategoryRecycler() {
        arraylist = ArrayList()
        gridLayoutManager =
            GridLayoutManager(requireContext(), 2)
        binding.rvProduct.layoutManager = gridLayoutManager
        productAdapter =
            ProductAdapter(requireContext(), arraylist,this)
        binding.rvProduct.adapter = productAdapter
        binding.rvProduct.addItemDecoration(GridSpacingItemDecoration(2, 50, true))

        arraylist.add(ProductItem_List(R.drawable.login_back_image,"Item 1","900.00","1000.00","25% OFF"))
        arraylist.add(ProductItem_List(R.drawable.login_back_image,"Item 2","1900.00","2000.00","20% OFF"))
        arraylist.add(ProductItem_List(R.drawable.login_back_image,"Item 3","2900.00","3000.00","15% OFF"))
        arraylist.add(ProductItem_List(R.drawable.login_back_image,"Item 4","3900.00","4000.00","10% OFF"))
        arraylist.add(ProductItem_List(R.drawable.login_back_image,"Item 5","4900.00","5000.00","25% OFF"))
        arraylist.add(ProductItem_List(R.drawable.login_back_image,"Item 6","5900.00","6000.00","20% OFF"))
        arraylist.add(ProductItem_List(R.drawable.login_back_image,"Item 7","6900.00","7000.00","15% OFF"))
        arraylist.add(ProductItem_List(R.drawable.login_back_image,"Item 8","7900.00","8000.00","10% OFF"))

    }

    override fun onItemClick(productitemList: ProductItem_List) {

        showProductDetailsPage()

    }

    private fun showProductDetailsPage() {
        (activity as DashboardActivity).addFragment(
            ProductDetailsFragment.newInstance() as Fragment
        )
    }



}


