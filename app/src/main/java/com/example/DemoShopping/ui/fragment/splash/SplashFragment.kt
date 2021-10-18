package com.example.DemoShopping.ui.fragment.splash

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.DemoShopping.R
import com.example.DemoShopping.ui.activity.BaseActivity
import com.example.DemoShopping.ui.fragment.login.LoginFragment
import com.example.DemoShopping.utils.Screens
import org.koin.androidx.viewmodel.ext.android.getViewModel

class SplashFragment : Fragment() {

    private lateinit var viewModel: SplashViewModel

    companion object {
        fun getInstance(): SplashFragment {

            return SplashFragment()
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.splash_fragment, container, false)
        viewModel = getViewModel()
        initView(view)
        return view
    }


    @SuppressLint("FragmentLiveDataObserve")
    private fun initView(view: View?) {

        viewModel._loadingState.observe(this, Observer {
            when(it){

                Screens.LOGIN.ordinal->{
                    (activity as BaseActivity).addFragment(LoginFragment.getInstance() as Fragment)
                }

                /*Screens.DASHBOARD.ordinal->{
                    activity?.startActivity(Intent(activity, DashboardActivity::class.java))
                    activity?.finish()
                }
*/
            }

        })
    }

}