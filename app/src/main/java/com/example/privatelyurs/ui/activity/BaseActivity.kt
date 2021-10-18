package com.example.privatelyurs.ui.activity

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.fragment.app.Fragment
import com.example.privatelyurs.R
import com.example.privatelyurs.ui.fragment.login.LoginFragment
import com.example.privatelyurs.ui.fragment.splash.SplashFragment
import com.example.privatelyurs.utils.IS_LOGOUT

class BaseActivity : AppCompatActivity() {
    private val appinBackground = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        setContentView(R.layout.activity_base)


      /*  if (Build.VERSION.SDK_INT >= 21) {
           val window: Window = window
           window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
           window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
           window.statusBarColor = resources.getColor(R.color.color_transparent)

       }
*/

        initView()
    }

    private fun initView() {


        if (intent != null && intent.hasExtra(IS_LOGOUT) && intent.getBooleanExtra(IS_LOGOUT,false)) {
            addFragment(LoginFragment.getInstance() as Fragment)
        } else {
            addFragment(SplashFragment.getInstance() as Fragment)
        }
    }

    override fun onBackPressed() {

        if (supportFragmentManager.backStackEntryCount == 1) {

            finish()
        }else{
            super.onBackPressed()
        }
    }

    /**
     * ************************
     * For replace new Fragment
     * ************************
     */
    fun replaceNewFragment(newInsatnce: Fragment, resid: Int): Boolean {
        return replaceNewFragment(newInsatnce, resid, false)
    }

    fun replaceFragment(newInsatnce: Fragment, addToBackstack: Boolean): Boolean {
        return replaceNewFragment(newInsatnce, R.id.container, addToBackstack)
    }


    /**
     * ********************
     * For add new Fragment
     * ********************
     */
    fun addFragment(newInsatnce: Fragment): Boolean {
        val fragment_name = newInsatnce.javaClass.simpleName
        val fragment = supportFragmentManager.findFragmentByTag(fragment_name)
        if (fragment == null || fragment_name == "ProductFragment") {
            val transaction = supportFragmentManager.beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in, 0)
            transaction.add(R.id.container, newInsatnce, fragment_name)

            transaction.addToBackStack(fragment_name)
            if (appinBackground)
                transaction.commitAllowingStateLoss()
            else
                transaction.commit()
            return true
        }
        return false
    }

    /**
     * ************************
     * For replace new Fragment
     * ************************
     */
    private fun replaceNewFragment(
        newInsatnce: Fragment,
        resid: Int,
        addToBackstack: Boolean
    ): Boolean {
        try {
            val fragment_name = newInsatnce.javaClass.simpleName
            val fragment = supportFragmentManager.findFragmentByTag(fragment_name)
            if (fragment == null) {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.setCustomAnimations(android.R.anim.slide_in_left, 0)
                if (addToBackstack) {
                    transaction.addToBackStack(fragment_name)
                }
                transaction.replace(resid, newInsatnce, fragment_name)
                if (appinBackground)
                    transaction.commitAllowingStateLoss()
                else
                    transaction.commit()
                return true
            } else {
                return false
            }
        } catch (e: Exception) {
            e.printStackTrace()
            return false

        }
    }




}