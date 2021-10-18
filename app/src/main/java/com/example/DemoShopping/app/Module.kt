package com.example.DemoShopping.app


import com.example.DemoShopping.ui.activity.dashboard.DashboardViewModel
import com.example.DemoShopping.ui.fragment.addressbook.AddressBookViewModel
import com.example.DemoShopping.ui.fragment.category.CategoryfragmentViewModel
import com.example.DemoShopping.ui.fragment.changepassword.ChangePasswordViewModel
import com.example.DemoShopping.ui.fragment.forgetpassword.ForgotPasswordViewModel
import com.example.DemoShopping.ui.fragment.home.HomeFragmentViewModel
import com.example.DemoShopping.ui.fragment.login.LoginViewModel
import com.example.DemoShopping.ui.fragment.orderdetails.OrderDetailsViewModel
import com.example.DemoShopping.ui.fragment.orders.OrderViewModel
import com.example.DemoShopping.ui.fragment.product.ProductViewModel
import com.example.DemoShopping.ui.fragment.productdetails.ProductDetailsViewModel
import com.example.DemoShopping.ui.fragment.profile.ProfileFragmentViewModel
import com.example.DemoShopping.ui.fragment.profiledetails.ProfileDetailsViewModel
import com.example.DemoShopping.ui.fragment.splash.SplashViewModel
import com.example.DemoShopping.ui.fragment.wishlist.WishListFragmetViewModel
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

