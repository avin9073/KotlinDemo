package com.example.DemoShopping.ui.fragment.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.DemoShopping.utils.Prefs
import com.example.DemoShopping.utils.Screens
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