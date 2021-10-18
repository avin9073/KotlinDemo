package com.example.DemoShopping.ui.fragment.profiledetails

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.DemoShopping.R
import com.example.DemoShopping.databinding.ProfileDetailsFragmentBinding
import com.example.DemoShopping.ui.activity.dashboard.DashboardActivity
import com.example.DemoShopping.ui.fragment.changepassword.ChangePasswordFragment
import com.example.DemoShopping.utils.Screens
import org.koin.androidx.viewmodel.ext.android.getViewModel
import java.util.*

class ProfileDetailsFragment : Fragment() {

    private lateinit var viewModel: ProfileDetailsViewModel
    private lateinit var binding: ProfileDetailsFragmentBinding

    companion object {
        fun newInstance() =
            ProfileDetailsFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.profile_details_fragment, container, false)
        viewModel = getViewModel()



        return binding.root
    }

    override fun onResume() {
        super.onResume()

        (activity as DashboardActivity).setToolbarVisibility(true)
        (activity as DashboardActivity).setBackButton(true)
        (activity as DashboardActivity).setBottomTabVisibility(false)
        (activity as DashboardActivity).setToolbarTitle(getString(R.string.profile_details))

    }

    @SuppressLint("FragmentLiveDataObserve")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        viewModel._loadingScreen.observe(this, Observer{
            when(it){

                Screens.CHANGEPASSWORD.ordinal ->{
                    (activity as DashboardActivity).addFragment(
                        ChangePasswordFragment.newInstance() as Fragment)
                }


            }
        })

        binding.viewmodel = viewModel
    }



}
