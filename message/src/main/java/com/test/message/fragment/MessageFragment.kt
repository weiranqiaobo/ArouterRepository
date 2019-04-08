package com.test.message.fragment

import com.test.base.basecomponent.KotlinBaseFragment
import com.test.message.R

class MessageFragment : KotlinBaseFragment() {
    override fun initOthers() {

    }

    override fun getPresenter(): Any? = null

    override fun getLayoutId(): Int = R.layout.me_fragment_message

    override fun initView() {
    }

    override fun lazyLoad() {

    }

}