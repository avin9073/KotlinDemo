package com.example.privatelyurs.ui.fragment.changepassword

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ChangePasswordViewModel : ViewModel() {

    val strChangePswrd = MutableLiveData<String>()
    val strNewPswrd = MutableLiveData<String>()
    val strConfirmPswrd = MutableLiveData<String>()

}