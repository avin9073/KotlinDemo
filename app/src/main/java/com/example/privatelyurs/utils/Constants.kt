package com.example.privatelyurs.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import com.example.privatelyurs.R
import com.example.privatelyurs.ui.fragment.login.LoginFragment
import org.jetbrains.anko.design.snackbar


const val IS_LOGOUT = "isLogout"

enum class Screens {
    DEFAULT,SPLASH,LOGIN,DASHBOARD,FORGETPASSWORD,HOME,CATEGORY,WISHLIST,PROFILE,PROFILEDETAILS,CHANGEPASSWORD,ORDERS,ADDRESSBOOK
}

enum class Tabs {HOME,CATEGORY,WISHLIST,PROFILE}

fun showSnackMessage(ctx: Context,string: String, view: View) {
    if (ctx != null) {
        view.snackbar(string).setActionTextColor(ContextCompat.getColor(ctx, R.color.white))
            .view.setBackgroundColor(ContextCompat.getColor(ctx, R.color.pink))
    }
}

fun showSnackMessageError(ctx: Context, string: String, view: View) {
    if (ctx != null) {
        view.snackbar(string).setActionTextColor(ContextCompat.getColor(ctx, R.color.white))
            .view.setBackgroundColor(ContextCompat.getColor(ctx, R.color.pink))
    }
}

/*
fun showSnackMessage(ctx: Context, string: String, view: View) {
    if (ctx != null) {
        view.snackbar(string).setActionTextColor(ContextCompat.getColor(ctx, R.color.white))
            .view.setBackgroundColor(ContextCompat.getColor(ctx, R.color.pink))
    }
*/

fun hideSoftKeyboard(ctx: Context, view: View) {
    if (view != null && ctx != null) {
        val imm = ctx.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
