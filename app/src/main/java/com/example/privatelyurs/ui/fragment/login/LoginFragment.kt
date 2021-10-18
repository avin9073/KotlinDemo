package com.example.privatelyurs.ui.fragment.login

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.privatelyurs.R
import com.example.privatelyurs.databinding.LoginFragmentBinding
import com.example.privatelyurs.ui.activity.BaseActivity
import com.example.privatelyurs.ui.activity.dashboard.DashboardActivity
import com.example.privatelyurs.ui.fragment.forgetpassword.ForgotPasswordFragment
import com.example.privatelyurs.utils.Screens
import org.koin.androidx.viewmodel.ext.android.getViewModel

class LoginFragment : Fragment() {

    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: LoginFragmentBinding

    companion object {
        fun getInstance(): LoginFragment {

            return LoginFragment()
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.login_fragment, container, false)
        viewModel = getViewModel()
        return binding.root
    }

    @SuppressLint("FragmentLiveDataObserve")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.localEmailErrorMessage.observe(this, Observer {
//            showSnackMessage(this, it, binding.root)
            binding.tvErrorEmailMsz.visibility=View.VISIBLE

        })

        viewModel.localPassErrorMessage.observe(this, Observer {
            //showSnackMessage(this, it, binding.root)
            binding.tvErrorEmailPassword.visibility=View.VISIBLE
        })



        viewModel._loadingScreen.observe(this, Observer{
            when(it){

                Screens.FORGETPASSWORD.ordinal ->{
                    (activity as BaseActivity).addFragment(
                        ForgotPasswordFragment.newInstance() as Fragment)
                }

                Screens.DASHBOARD.ordinal -> {
                    activity?.startActivity(Intent(activity, DashboardActivity::class.java))
                    activity?.finish()
                }
            }
        })

        binding.viewmodel = viewModel
    }


    }

