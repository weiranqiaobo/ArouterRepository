package com.test.me.fragment

import com.test.base.basecomponent.KotlinBaseFragment
import com.test.me.R

class MeFragment : KotlinBaseFragment() {
    override fun initOthers() {

    }

    override fun getPresenter(): Any? = null

    override fun getLayoutId(): Int = R.layout.me_fragment_me

    override fun initView() {
    }

    override fun lazyLoad() {

    }

}