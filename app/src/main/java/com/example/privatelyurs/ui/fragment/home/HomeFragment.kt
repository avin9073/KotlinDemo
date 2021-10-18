package com.example.privatelyurs.ui.fragment.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.privatelyurs.R
import com.example.privatelyurs.databinding.HomeFragmentBinding
import com.example.privatelyurs.model.entity.CategoryItem_List
import com.example.privatelyurs.model.entity.HomeItem_List
import com.example.privatelyurs.ui.activity.dashboard.DashboardActivity
import com.example.privatelyurs.ui.fragment.category.CategoryFragment
import com.example.privatelyurs.ui.fragment.category.CategoryItemAdapter
import com.example.privatelyurs.ui.fragment.profile.ProfileFragment
import com.example.privatelyurs.ui.fragment.wishlist.WishListFragment
import com.example.privatelyurs.utils.Tabs
import org.koin.androidx.viewmodel.ext.android.getViewModel
import java.util.ArrayList

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeFragmentViewModel
    private lateinit var binding : HomeFragmentBinding
    private var arraylist = ArrayList<HomeItem_List>()
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var homeAdapter: HomeAdapter

    companion object {
        fun getInstance(): HomeFragment? {

            return HomeFragment()
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)
        viewModel= getViewModel()


        return binding.root
    }

    override fun onResume() {
        super.onResume()

        (activity as DashboardActivity).setToolbarVisibility(false)
        (activity as DashboardActivity).setBottomTabVisibility(true)
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
        binding.rvHome.layoutManager = linearLayoutManager
        homeAdapter =
            HomeAdapter(requireContext(), arraylist)
        binding.rvHome.adapter = homeAdapter

        arraylist.add(HomeItem_List(R.drawable.login_back_image,"Category1"))
        arraylist.add(HomeItem_List(R.drawable.login_back_image,"Category2"))
        arraylist.add(HomeItem_List(R.drawable.login_back_image,"Category3"))
        arraylist.add(HomeItem_List(R.drawable.login_back_image,"Category4"))
        arraylist.add(HomeItem_List(R.drawable.login_back_image,"Category5"))
        arraylist.add(HomeItem_List(R.drawable.login_back_image,"Category6"))


    }


}