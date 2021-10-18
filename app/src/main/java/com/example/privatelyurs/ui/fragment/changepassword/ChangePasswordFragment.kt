package com.example.privatelyurs.ui.fragment.changepassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.privatelyurs.R
import com.example.privatelyurs.databinding.ChangePasswordFragmentBinding
import com.example.privatelyurs.databinding.ProfileDetailsFragmentBinding
import com.example.privatelyurs.ui.activity.dashboard.DashboardActivity
import com.example.privatelyurs.ui.fragment.profiledetails.ProfileDetailsFragment
import com.example.privatelyurs.ui.fragment.profiledetails.ProfileDetailsViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class ChangePasswordFragment : Fragment() {

    private lateinit var viewModel: ChangePasswordViewModel
    private lateinit var binding: ChangePasswordFragmentBinding

    companion object {
        fun newInstance() = ChangePasswordFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.change_password_fragment, container, false)
        viewModel = getViewModel()



        return binding.root
    }

    override fun onResume() {
        super.onResume()

        (activity as DashboardActivity).setToolbarVisibility(true)
        (activity as DashboardActivity).setBottomTabVisibility(false)
        (activity as DashboardActivity).setToolbarTitle(getString(R.string.change_password))
        (activity as DashboardActivity).setToolbarActionButtonVisibility(false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.viewmodel = viewModel

    }


}