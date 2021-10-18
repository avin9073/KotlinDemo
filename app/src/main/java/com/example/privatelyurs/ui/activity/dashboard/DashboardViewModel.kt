package com.example.privatelyurs.ui.activity.dashboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.privatelyurs.utils.Prefs
import com.example.privatelyurs.utils.Screens

open class DashboardViewModel : ViewModel() {

    val bottomBarVisible= MutableLiveData<Int>()
    val bottomViewVisibility=  MutableLiveData<Int>()

    init {

        Prefs.isHomeSelected = 0
        bottomBarViewVisibilityManage()

    }

    fun onHomePageSelected(){

        if (Prefs.isHomeSelected != 0) {
            Prefs.isHomeSelected = 0
            bottomBarViewVisibilityManage()
        }
        else {}

    }

    fun onCategorySelected(){

        if (Prefs.isHomeSelected == 0  ) {
            Prefs.isHomeSelected = 1

            bottomBarViewVisibilityManage()
        }else if (Prefs.isHomeSelected == 2 ){
            Prefs.isHomeSelected = 1
            bottomBarViewVisibilityManage()
        }
        else if (Prefs.isHomeSelected == 3 ){
            Prefs.isHomeSelected = 1
            bottomBarViewVisibilityManage()
        }
        else {}


    }

    fun onWishlistSelected(){

        if (Prefs.isHomeSelected == 0  ) {
            Prefs.isHomeSelected = 2

            bottomBarViewVisibilityManage()
        }else if (Prefs.isHomeSelected == 1 ){
            Prefs.isHomeSelected = 2
            bottomBarViewVisibilityManage()
        }
        else if (Prefs.isHomeSelected == 3 ){
            Prefs.isHomeSelected = 2
            bottomBarViewVisibilityManage()
        }
        else {}


    }

    fun onProfileSelected(){

        if (Prefs.isHomeSelected == 0  ) {
            Prefs.isHomeSelected = 3

            bottomBarViewVisibilityManage()
        }else if (Prefs.isHomeSelected == 1 ){
            Prefs.isHomeSelected = 3
            bottomBarViewVisibilityManage()
        }
        else if (Prefs.isHomeSelected == 2 ){
            Prefs.isHomeSelected = 3
            bottomBarViewVisibilityManage()
        }
        else {}


    }

    private fun bottomBarViewVisibilityManage(){

        if(Prefs.isHomeSelected == 1){
            bottomBarVisible.postValue(1)
        }else{
            bottomBarVisible.postValue(Prefs.isHomeSelected)
        }
    }

    fun backToHomeSec(){
        onHomePageSelected()
    }


}