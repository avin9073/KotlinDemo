package com.example.privatelyurs.ui.fragment.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.privatelyurs.utils.Screens

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