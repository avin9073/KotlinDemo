package com.example.DemoShopping.utils

import android.app.Application
import android.content.SharedPreferences

object Prefs {

    private const val IS_LOGGEDIN = "is_loggedin"
    private const val PREFS_FILENAME = "com.privatelyurs.com.utility.prefs"
    val IS_HOME_SELECTED = "is_profile_selected"
    private lateinit var prefs: SharedPreferences
    private lateinit var application: Application

    var isLoggedIn: Boolean
        get() = prefs.getBoolean(IS_LOGGEDIN, false)
        set(value) = prefs.edit().putBoolean(IS_LOGGEDIN, value).apply()

    fun init(application: Application) {
        this.application = application
        prefs = Prefs.application.getSharedPreferences(PREFS_FILENAME, 0)

    }

    var isHomeSelected: Int
        get() = prefs.getInt(IS_HOME_SELECTED, 0)
        set(value) = prefs.edit().putInt(IS_HOME_SELECTED, value).apply()



}