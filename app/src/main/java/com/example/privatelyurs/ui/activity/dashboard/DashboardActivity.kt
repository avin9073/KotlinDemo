package com.example.privatelyurs.ui.activity.dashboard

import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import android.view.View
import android.view.WindowManager
import android.widget.FrameLayout


import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import com.example.privatelyurs.R
import com.example.privatelyurs.databinding.ActivityDashboardBinding
import com.example.privatelyurs.ui.fragment.category.CategoryFragment
import com.example.privatelyurs.ui.fragment.home.HomeFragment
import com.example.privatelyurs.ui.fragment.profile.ProfileFragment
import com.example.privatelyurs.ui.fragment.wishlist.WishListFragment
import com.example.privatelyurs.utils.Prefs
import com.example.privatelyurs.utils.Tabs
import com.example.privatelyurs.utils.showSnackMessage
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.toolbar.view.*
import org.jetbrains.anko.Android
import org.koin.androidx.viewmodel.ext.android.getViewModel
import java.text.SimpleDateFormat
import java.util.*


class DashboardActivity : AppCompatActivity() {

    private lateinit var viewModel: DashboardViewModel
    private lateinit var binding: ActivityDashboardBinding
    private var manager: FragmentManager? = null
    var isBackEvent = false
    var isbackPressed = false
    private val appinBackground = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard)
        viewModel = getViewModel()
        setSupportActionBar(binding.toolbar as Toolbar?)
        binding.viewmodel = viewModel

        manager = supportFragmentManager
       // addFragment(HomeFragment.getInstance() as Fragment)

    }



    override fun onBackPressed() {


        if (isBackEvent) {
            if (manager!!.backStackEntryCount == 1) {

                setBackButton(false)
                isBackEvent = false
            }

            super.onBackPressed()



            return
        } else {
            if (supportFragmentManager.findFragmentById(R.id.container) is HomeFragment) {
                var handler = Handler()
                if (isbackPressed) {
                    super.onBackPressed()
                    return
                }
                isbackPressed = true
                showSnackMessage(this, getString(R.string.app_close_alert), binding.toolbar as View)
                handler.postDelayed({
                    isbackPressed = false
                }, 3000)
            } else {

                homePartSelected()

            }


        }

    }

    fun replaceNewFragment(newInsatnce: Fragment, resid: Int): Boolean {
        return replaceNewFragment(newInsatnce, resid, false)
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
            val fragment = manager!!.findFragmentByTag(fragment_name)
            if (fragment == null) {
                val transaction = manager!!.beginTransaction()
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

    /**
     * ********************
     * For add new Fragment
     * ********************
     */
    fun addFragment(newInsatnce: Fragment): Boolean {
        val fragment_name = newInsatnce.javaClass.simpleName
        val fragment = manager!!.findFragmentByTag(fragment_name)
        if (fragment == null || fragment_name == "ProductFragment") {
            isBackEvent = true
            val transaction =
                manager!!.beginTransaction().setCustomAnimations(android.R.anim.slide_in_left, 0)
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


    fun setToolbarTitle(title: String) {
        binding.toolbar.tvToolbarTitle?.text = title
    }

    fun setToolbarActionText(text: String){
        binding.toolbar.toolbarActionButton?.text = text
    }

    fun setToolbarActionButtonVisibility(isShown : Boolean) {
        if (isShown){
            binding.toolbar.toolbarActionButton?.visibility = View.VISIBLE
        }else{
            binding.toolbar.toolbarActionButton?.visibility = View.GONE
        }

    }

    fun setToolbarVisibility(isShown : Boolean) {
        if (isShown){
            binding.toolbar.visibility = View.VISIBLE
        }else{
            binding.toolbar.visibility = View.GONE
        }

    }

    fun setBottomTabVisibility(isShown : Boolean){
        if (isShown){
            binding.bottomTabView.visibility = View.VISIBLE
        }else{
            binding.bottomTabView.visibility = View.GONE
        }
    }


    @SuppressLint("FragmentLiveDataObserve")
    override fun onResume() {
        super.onResume()

        viewModel.bottomBarVisible.observe(this, Observer {
            when(it){

                Tabs.HOME.ordinal ->{
                    homePartSelected()
                }

                Tabs.CATEGORY.ordinal -> {
                    categoryPartSelected()
                }

                Tabs.WISHLIST.ordinal -> {
                    wishlistPartSelected()
                }

                Tabs.PROFILE.ordinal -> {
                    profilePartSelected()
                }

            }
        })

    }

    fun setBackButton(isShown: Boolean) {


        if (supportActionBar != null) {
            supportActionBar!!.setDisplayShowTitleEnabled(false)
            if (isShown) {
                supportActionBar!!.setHomeAsUpIndicator(R.drawable.back_arrow)

            } else {

            }

        }
    }

    private fun homePartSelected() {
        binding.homeIconImage.setImageDrawable(resources.getDrawable(R.drawable.ic_home_icon_select))
        binding.wishlistIconImage.setImageDrawable(resources.getDrawable(R.drawable.ic_wishlist_icon_deselect))
        binding.profileIconImage.setImageDrawable(resources.getDrawable(R.drawable.ic_account_icon_deselect))
        binding.menuIconImage.setImageDrawable(resources.getDrawable(R.drawable.ic_category_icon_deselect))

        replaceNewFragment(HomeFragment.getInstance()!!, R.id.container)

    }

    fun categoryPartSelected() {

        binding.menuIconImage.setImageDrawable(resources.getDrawable(R.drawable.ic_category_icon_select))
        binding.homeIconImage.setImageDrawable(resources.getDrawable(R.drawable.ic_home_icon_deselect))
        binding.wishlistIconImage.setImageDrawable(resources.getDrawable(R.drawable.ic_wishlist_icon_deselect))
        binding.profileIconImage.setImageDrawable(resources.getDrawable(R.drawable.ic_account_icon_deselect))
        replaceNewFragment(CategoryFragment.getInstance()!!, R.id.container)
    }

    fun wishlistPartSelected() {

        binding.wishlistIconImage.setImageDrawable(resources.getDrawable(R.drawable.ic_wishlist_icon_select))
        binding.profileIconImage.setImageDrawable(resources.getDrawable(R.drawable.ic_account_icon_deselect))
        binding.homeIconImage.setImageDrawable(resources.getDrawable(R.drawable.ic_home_icon_deselect))
        binding.menuIconImage.setImageDrawable(resources.getDrawable(R.drawable.ic_category_icon_deselect))

        replaceNewFragment(WishListFragment.getInstance()!!, R.id.container)

    }

    fun profilePartSelected() {
        binding.profileIconImage.setImageDrawable(resources.getDrawable(R.drawable.ic_account_icon_select))
        binding.wishlistIconImage.setImageDrawable(resources.getDrawable(R.drawable.ic_wishlist_icon_deselect))
        binding.homeIconImage.setImageDrawable(resources.getDrawable(R.drawable.ic_home_icon_deselect))
        binding.menuIconImage.setImageDrawable(resources.getDrawable(R.drawable.ic_category_icon_deselect))

        replaceNewFragment(ProfileFragment.getInstance()!!, R.id.container)

    }

    fun homeSecShowManageFromOnBackPress(){
        viewModel.backToHomeSec()
    }




}

