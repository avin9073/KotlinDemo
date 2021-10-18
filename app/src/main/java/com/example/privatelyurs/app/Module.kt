package com.example.privatelyurs.app


import com.example.privatelyurs.ui.activity.dashboard.DashboardViewModel
import com.example.privatelyurs.ui.fragment.addressbook.AddressBookViewModel
import com.example.privatelyurs.ui.fragment.category.CategoryfragmentViewModel
import com.example.privatelyurs.ui.fragment.changepassword.ChangePasswordViewModel
import com.example.privatelyurs.ui.fragment.forgetpassword.ForgotPasswordViewModel
import com.example.privatelyurs.ui.fragment.home.HomeFragmentViewModel
import com.example.privatelyurs.ui.fragment.login.LoginViewModel
import com.example.privatelyurs.ui.fragment.orderdetails.OrderDetailsViewModel
import com.example.privatelyurs.ui.fragment.orders.OrderViewModel
import com.example.privatelyurs.ui.fragment.product.ProductViewModel
import com.example.privatelyurs.ui.fragment.productdetails.ProductDetailsViewModel
import com.example.privatelyurs.ui.fragment.profile.ProfileFragmentViewModel
import com.example.privatelyurs.ui.fragment.profiledetails.ProfileDetailsViewModel
import com.example.privatelyurs.ui.fragment.splash.SplashViewModel
import com.example.privatelyurs.ui.fragment.wishlist.WishListFragmetViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module



val viewModelModule = module {
    viewModel { SplashViewModel()}
    viewModel { LoginViewModel()}
    viewModel { DashboardViewModel()}
    viewModel { ForgotPasswordViewModel() }
    viewModel { HomeFragmentViewModel() }
    viewModel { ProfileFragmentViewModel() }
    viewModel { CategoryfragmentViewModel() }
    viewModel { WishListFragmetViewModel() }
    viewModel { ProfileDetailsViewModel() }
    viewModel { ChangePasswordViewModel() }
    viewModel { OrderViewModel() }
    viewModel { OrderDetailsViewModel() }
    viewModel { AddressBookViewModel() }
    viewModel { ProductViewModel() }
    viewModel { ProductDetailsViewModel() }


}

