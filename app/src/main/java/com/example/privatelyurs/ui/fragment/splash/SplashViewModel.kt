package com.example.privatelyurs.ui.fragment.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.privatelyurs.utils.Prefs
import com.example.privatelyurs.utils.Screens
import java.util.*
import kotlin.concurrent.schedule

class SplashViewModel : ViewModel() {

    val _loadingState = MutableLiveData<Int>()

    init {

            startTimer(2000)

    }

    private fun startTimer(time: Long) {
        Timer("SettingUp", false).schedule(time) {
            onTrimerComleted()
        }
    }

    private fun onTrimerComleted() {
        if (!Prefs.isLoggedIn) {
            _loadingState.postValue(Screens.LOGIN.ordinal)
        } else {

        }
    }


}