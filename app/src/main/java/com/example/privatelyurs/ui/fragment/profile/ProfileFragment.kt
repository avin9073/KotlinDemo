package com.example.privatelyurs.ui.fragment.profile

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.privatelyurs.R
import com.example.privatelyurs.databinding.ProfileFragmentBinding
import com.example.privatelyurs.ui.activity.BaseActivity
import com.example.privatelyurs.ui.activity.dashboard.DashboardActivity
import com.example.privatelyurs.ui.fragment.addressbook.AddressBookFragment
import com.example.privatelyurs.ui.fragment.forgetpassword.ForgotPasswordFragment
import com.example.privatelyurs.ui.fragment.home.HomeFragment
import com.example.privatelyurs.ui.fragment.orders.OrderFragment
import com.example.privatelyurs.ui.fragment.profiledetails.ProfileDetailsFragment
import com.example.privatelyurs.utils.Screens
import org.koin.androidx.viewmodel.ext.android.getViewModel
import java.util.ArrayList


class ProfileFragment : Fragment() {

    private lateinit var viewModel: ProfileFragmentViewModel
    private lateinit var binding : ProfileFragmentBinding


    companion object {
        fun getInstance(): ProfileFragment? {

            return ProfileFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.profile_fragment, container, false)
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



        viewModel._loadingScreen.observe(this, Observer{
            when(it){

                Screens.PROFILEDETAILS.ordinal ->{
                    (activity as DashboardActivity).addFragment(
                        ProfileDetailsFragment.newInstance() as Fragment)
                }

                Screens.ORDERS.ordinal ->{
                    (activity as DashboardActivity).addFragment(
                        OrderFragment.newInstance() as Fragment)
                }

                Screens.ADDRESSBOOK.ordinal ->{
                    (activity as DashboardActivity).addFragment(
                        AddressBookFragment.newInstance() as Fragment)
                }


            }
        })

        binding.viewmodel = viewModel
    }






}