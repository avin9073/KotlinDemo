package com.example.privatelyurs.ui.fragment.forgetpassword

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.privatelyurs.utils.Screens

class ForgotPasswordViewModel : ViewModel() {

    val strEmailLogin = MutableLiveData<String>()
    val _loadingScreen = MutableLiveData<Int>()

fun callPasswordReset(){

    _loadingScreen.postValue(Screens.LOGIN.ordinal)

}

}