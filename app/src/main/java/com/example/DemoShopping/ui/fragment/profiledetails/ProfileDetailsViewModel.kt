package com.example.DemoShopping.ui.fragment.profiledetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.DemoShopping.utils.Screens

class ProfileDetailsViewModel : ViewModel() {

    val strFullName = MutableLiveData<String>()
    val strEmail = MutableLiveData<String>()
    val strMobileNumber = MutableLiveData<String>()
    val strAltMobileNumber = MutableLiveData<String>()


    val _loadingScreen = MutableLiveData<Int>()

    fun callChangePassword(){

        _loadingScreen.postValue(Screens.CHANGEPASSWORD.ordinal)
    }



}