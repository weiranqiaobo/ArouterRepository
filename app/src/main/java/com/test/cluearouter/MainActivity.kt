package com.test.cluearouter

import android.support.v7.app.AppCompatDelegate
import com.test.base.adapter.BaseVPFragmentAdapter
import com.test.base.basecomponent.KotlinBaseActivity
import com.test.base.basecomponent.KotlinBaseFragment
import com.test.clue_manager.fragment.ClueFragment
import com.test.me.fragment.MeFragment
import com.test.message.fragment.MessageFragment
import kotlinx.android.synthetic.main.activity_app.*

class MainActivity : KotlinBaseActivity() {

    private var cluFragment: ClueFragment? = null
    private var messageFragment: MessageFragment? = null
    private var meFragment: MeFragment? = null
    private var fragmentList = mutableListOf<KotlinBaseFragment>()
    override fun initOthers() {

    }

    init {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }

    override fun getPresenter(): Any? = null

    override fun getRootResId(): Int = R.layout.activity_app

    override fun initData() {}
    override fun initView() {
        navigation_tab.enableShiftingMode(false)
        navigation_tab.enableItemShiftingMode(false)
        cluFragment = ClueFragment()
        messageFragment = MessageFragment()
        meFragment = MeFragment()
        fragmentList.add(messageFragment!!)
        fragmentList.add(cluFragment!!)
        fragmentList.add(meFragment!!)
        viewpager_main.adapter = BaseVPFragmentAdapter(supportFragmentManager, fragmentList)
        navigation_tab.setupWithViewPager(viewpager_main)
    }

    override fun startNet() {}
    override fun initListener() {}

}
