package com.example.DemoShopping.ui.fragment.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.DemoShopping.utils.Screens

class LoginViewModel : ViewModel() {

    val strEmailLogin = MutableLiveData<String>()
    val strpassword = MutableLiveData<String>()
    val _loadingScreen = MutableLiveData<Int>()
    val isCorrect = MutableLiveData<Boolean>()
    val isCorrectPass = MutableLiveData<Boolean>()
    val hideKeyBoard: MutableLiveData<Boolean> = MutableLiveData()
    val localEmailErrorMessage: MutableLiveData<String> = MutableLiveData()
    val localPassErrorMessage: MutableLiveData<String> = MutableLiveData()
    val errorMessage: MutableLiveData<Int> = MutableLiveData()
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()



    fun passwordRetrieve() {
        _loadingScreen.postValue(Screens.FORGETPASSWORD.ordinal)
    }

    fun callLogin() {

       // _loadingScreen.postValue(Screens.DASHBOARD.ordinal)

       /* hideKeyBoard.postValue(true)

        if (TextUtils.isEmpty(strEmailLogin.value)) {
            localEmailErrorMessage.value = "Please enter your email"

            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(strEmailLogin.value.toString())
                .matches()
        ) {
            localEmailErrorMessage.value = "Please enter a valid email"
            return
        }

        if (TextUtils.isEmpty(strpassword.value)) {
            localPassErrorMessage.value ="Please enter password"
            return
        }
        if (strpassword.value?.length!! < 6) {
            localPassErrorMessage.value =
                "Password should be 6 characters"
            return
        }*/

        _loadingScreen.postValue(Screens.DASHBOARD.ordinal)

       /* if (!InternetUtil.isInternetOn()) {
            errorMessage.value = R.string.no_internet_msg
            return
        }*/

        //_loadingScreen.postValue(Screens.DASHBOARD.ordinal)

    /*    viewModelScope.launch {
            try {
                onRetrieveStart()
            *//*  loginRepository.userLogin(
                    if (TextUtils.isEmpty(strEmailLogin.value)) "" else strEmailLogin.value!!,
                    if (TextUtils.isEmpty(strpassword.value)) "" else strpassword.value!!,
                    DEVICE_TYPE, ""
                )*//*

                retrieveUserDetails()
            } catch (e: Exception) {
                errorMessage.value = R.string.something_went_wrong_pls_try_again
                loadingVisibility.value = View.GONE
            }
        }
    }

    private fun onRetrieveStart() {
        loadingVisibility.value = View.VISIBLE
    }

    private fun retrieveUserDetails() {
       *//* if (loginRepository.userDetailsResponse.status == 1) {

            loadingVisibility.value = View.GONE
            //successMessage.postValue(loginRegisterRepository.userDetailsResponse.message)

            Prefs.saveInPreferense(loginRepository.userDetailsResponse.data)
            Prefs.isLoggedIn = true

*//*
            _loadingScreen.postValue(Screens.DASHBOARD.ordinal)*//*) } else {
            loadingVisibility.value = View.GONE
            errorMessageFailure.postValue(loginRepository.userDetailsResponse.message)
        }
    }*/
}
}