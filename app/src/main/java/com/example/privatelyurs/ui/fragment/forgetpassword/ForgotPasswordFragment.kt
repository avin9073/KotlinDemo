package com.example.privatelyurs.ui.fragment.forgetpassword

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.privatelyurs.R
import com.example.privatelyurs.databinding.ForgotPasswordFragmentBinding

import com.example.privatelyurs.utils.Screens
import org.koin.androidx.viewmodel.ext.android.getViewModel


class ForgotPasswordFragment : Fragment() {

    private lateinit var viewModel: ForgotPasswordViewModel
    private lateinit var binding : ForgotPasswordFragmentBinding


    companion object {
        fun newInstance() = ForgotPasswordFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.forgot_password_fragment, container, false)
        viewModel = getViewModel()
        return binding.root
    }


    @SuppressLint("FragmentLiveDataObserve")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel._loadingScreen.observe(this, Observer {
            when(it){
                Screens.LOGIN.ordinal -> {
                    requireActivity().onBackPressed()
                }
            }
        })

        binding.viewmodel = viewModel


    }



}