package com.example.privatelyurs.ui.fragment.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.privatelyurs.R
import com.example.privatelyurs.databinding.CategoryFragmentBinding
import com.example.privatelyurs.databinding.ProfileFragmentBinding
import com.example.privatelyurs.model.entity.CategoryItem_List
import com.example.privatelyurs.model.entity.WishlistItem_List
import com.example.privatelyurs.ui.activity.dashboard.DashboardActivity
import com.example.privatelyurs.ui.fragment.home.HomeFragment
import com.example.privatelyurs.ui.fragment.orderdetails.OrderDetailsFragment
import com.example.privatelyurs.ui.fragment.product.ProductFragment
import com.example.privatelyurs.ui.fragment.profile.ProfileFragmentViewModel
import com.example.privatelyurs.ui.fragment.wishlist.WishlistItemAdapter
import com.example.privatelyurs.utils.GridSpacingItemDecoration
import org.koin.androidx.viewmodel.ext.android.getViewModel
import java.util.ArrayList


class CategoryFragment : Fragment(),CategoryItemAdapter.CategorylistListener {

    private lateinit var viewModel: CategoryfragmentViewModel
    private lateinit var binding : CategoryFragmentBinding
    private var arraylist = ArrayList<CategoryItem_List>()
    private lateinit var gridLayoutManager: GridLayoutManager
    private lateinit var categoryItemAdapter: CategoryItemAdapter


    companion object {
        fun getInstance(): CategoryFragment? {

            return CategoryFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.category_fragment, container, false)
        viewModel= getViewModel()

        (activity as DashboardActivity).setToolbarVisibility(false)

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        (activity as DashboardActivity).setToolbarVisibility(false)
        (activity as DashboardActivity).setBottomTabVisibility(true)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



        iniCategoryRecycler()


    }


    private fun iniCategoryRecycler() {
        arraylist = ArrayList()
        gridLayoutManager =
            GridLayoutManager(requireContext(), 2)
        binding.rvCategory.layoutManager = gridLayoutManager
        categoryItemAdapter =
            CategoryItemAdapter(requireContext(), arraylist,this)
        binding.rvCategory.adapter = categoryItemAdapter
        binding.rvCategory.addItemDecoration(GridSpacingItemDecoration(2, 50, true))

        arraylist.add(CategoryItem_List(R.drawable.login_back_image,"Item 1"))
        arraylist.add(CategoryItem_List(R.drawable.login_back_image,"Item 2"))
        arraylist.add(CategoryItem_List(R.drawable.login_back_image,"Item 3"))
        arraylist.add(CategoryItem_List(R.drawable.login_back_image,"Item 4"))
        arraylist.add(CategoryItem_List(R.drawable.login_back_image,"Item 5"))
        arraylist.add(CategoryItem_List(R.drawable.login_back_image,"Item 6"))
        arraylist.add(CategoryItem_List(R.drawable.login_back_image,"Item 7"))
        arraylist.add(CategoryItem_List(R.drawable.login_back_image,"Item 8"))

    }

    override fun onItemClick(categoryItemList: CategoryItem_List) {

        showProductPage()

    }

    private fun showProductPage() {
        (activity as DashboardActivity).addFragment(
            ProductFragment.newInstance() as Fragment
        )
    }


}