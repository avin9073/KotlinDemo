package com.example.DemoShopping.ui.fragment.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.DemoShopping.utils.Screens

class ProfileFragmentViewModel : ViewModel() {

    val _loadingScreen = MutableLiveData<Int>()

    fun callProfileDetails(){

        _loadingScreen.postValue(Screens.PROFILEDETAILS.ordinal)
    }

    fun callOrders(){

        _loadingScreen.postValue(Screens.ORDERS.ordinal)
    }

    fun callAddressBook(){

        _loadingScreen.postValue(Screens.ADDRESSBOOK.ordinal)
    }




}