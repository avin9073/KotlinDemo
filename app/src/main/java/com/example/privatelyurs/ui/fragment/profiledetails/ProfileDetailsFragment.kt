package com.example.privatelyurs.ui.fragment.profiledetails

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.privatelyurs.R
import com.example.privatelyurs.databinding.ProfileDetailsFragmentBinding
import com.example.privatelyurs.databinding.ProfileFragmentBinding
import com.example.privatelyurs.ui.activity.BaseActivity
import com.example.privatelyurs.ui.activity.dashboard.DashboardActivity
import com.example.privatelyurs.ui.fragment.changepassword.ChangePasswordFragment
import com.example.privatelyurs.ui.fragment.forgetpassword.ForgotPasswordFragment
import com.example.privatelyurs.ui.fragment.profile.ProfileFragment
import com.example.privatelyurs.ui.fragment.profile.ProfileFragmentViewModel
import com.example.privatelyurs.ui.fragment.wishlist.WishListFragment
import com.example.privatelyurs.utils.Screens
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
